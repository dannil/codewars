package com.github.dannil.codewars.asimplistictcpfinitestatemachine;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class TCP {

    public static String traverseStates(String[] events) {
        Map<StateEvent, StateEnum> transitions = new HashMap<>();
        transitions.put(new StateEvent(StateEnum.CLOSED, EventEnum.APP_PASSIVE_OPEN), StateEnum.LISTEN);
        transitions.put(new StateEvent(StateEnum.CLOSED, EventEnum.APP_ACTIVE_OPEN), StateEnum.SYN_SENT);
        transitions.put(new StateEvent(StateEnum.CLOSED, EventEnum.APP_PASSIVE_OPEN), StateEnum.LISTEN);
        transitions.put(new StateEvent(StateEnum.LISTEN, EventEnum.RCV_SYN), StateEnum.SYN_RCVD);
        transitions.put(new StateEvent(StateEnum.LISTEN, EventEnum.APP_SEND), StateEnum.SYN_SENT);
        transitions.put(new StateEvent(StateEnum.LISTEN, EventEnum.APP_CLOSE), StateEnum.CLOSED);
        transitions.put(new StateEvent(StateEnum.SYN_RCVD, EventEnum.APP_CLOSE), StateEnum.FIN_WAIT_1);
        transitions.put(new StateEvent(StateEnum.SYN_RCVD, EventEnum.RCV_ACK), StateEnum.ESTABLISHED);
        transitions.put(new StateEvent(StateEnum.SYN_SENT, EventEnum.RCV_SYN), StateEnum.SYN_RCVD);
        transitions.put(new StateEvent(StateEnum.SYN_SENT, EventEnum.RCV_SYN_ACK), StateEnum.ESTABLISHED);
        transitions.put(new StateEvent(StateEnum.SYN_SENT, EventEnum.APP_CLOSE), StateEnum.CLOSED);
        transitions.put(new StateEvent(StateEnum.ESTABLISHED, EventEnum.APP_CLOSE), StateEnum.FIN_WAIT_1);
        transitions.put(new StateEvent(StateEnum.ESTABLISHED, EventEnum.RCV_FIN), StateEnum.CLOSE_WAIT);
        transitions.put(new StateEvent(StateEnum.FIN_WAIT_1, EventEnum.RCV_FIN), StateEnum.CLOSING);
        transitions.put(new StateEvent(StateEnum.FIN_WAIT_1, EventEnum.RCV_FIN_ACK), StateEnum.TIME_WAIT);
        transitions.put(new StateEvent(StateEnum.FIN_WAIT_1, EventEnum.RCV_ACK), StateEnum.FIN_WAIT_2);
        transitions.put(new StateEvent(StateEnum.CLOSING, EventEnum.RCV_ACK), StateEnum.TIME_WAIT);
        transitions.put(new StateEvent(StateEnum.FIN_WAIT_2, EventEnum.RCV_FIN), StateEnum.TIME_WAIT);
        transitions.put(new StateEvent(StateEnum.TIME_WAIT, EventEnum.APP_TIMEOUT), StateEnum.CLOSED);
        transitions.put(new StateEvent(StateEnum.CLOSE_WAIT, EventEnum.APP_CLOSE), StateEnum.LAST_ACK);
        transitions.put(new StateEvent(StateEnum.LAST_ACK, EventEnum.RCV_ACK), StateEnum.CLOSED);

        State state = new State(StateEnum.CLOSED);
        for (String event : events) {
            EventEnum eventEnum = EventEnum.valueOf(event);
            state = state.getNext(transitions, eventEnum);
            if (state == null) {
                return "ERROR";
            }
        }
        return state.getState().name();
    }

    public static enum EventEnum {
        APP_PASSIVE_OPEN, APP_ACTIVE_OPEN, APP_SEND, APP_CLOSE, APP_TIMEOUT, RCV_SYN, RCV_ACK, RCV_SYN_ACK, RCV_FIN,
        RCV_FIN_ACK
    }

    public static enum StateEnum {
        CLOSED, LISTEN, SYN_SENT, SYN_RCVD, ESTABLISHED, CLOSE_WAIT, LAST_ACK, FIN_WAIT_1, FIN_WAIT_2, CLOSING,
        TIME_WAIT
    }

    public static class State {

        private StateEnum state;

        public State(StateEnum state) {
            this.state = state;
        }

        public StateEnum getState() {
            return state;
        }

        public State getNext(Map<StateEvent, StateEnum> transitions, EventEnum event) {
            StateEvent stateEvent = new StateEvent(state, event);
            StateEnum newState = transitions.get(stateEvent);
            if (newState != null) {
                return new State(newState);
            }
            return null;
        }

    }

    public static class StateEvent {

        private StateEnum state;
        private EventEnum event;

        public StateEvent(StateEnum state, EventEnum event) {
            this.state = state;
            this.event = event;
        }

        public StateEnum getState() {
            return state;
        }

        public EventEnum getEvent() {
            return event;
        }

        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof StateEvent)) {
                return false;
            }
            StateEvent other = (StateEvent) obj;
            return Objects.equals(state, other.state) && Objects.equals(event, other.event);
        }

        @Override
        public int hashCode() {
            return Objects.hash(state, event);
        }

    }

}
