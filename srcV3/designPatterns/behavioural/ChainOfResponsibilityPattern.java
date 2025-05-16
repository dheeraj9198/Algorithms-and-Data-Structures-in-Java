package designPatterns.behavioural;

/**
 * The Chain of Responsibility Pattern is a behavioral design pattern that allows an object to pass
 * a request along a chain of handlers, each of which can either handle the request or pass it along
 * to the next handler in the chain. This way, multiple handlers can process the request,
 * and the request is processed by the first eligible handler.
 */
public class ChainOfResponsibilityPattern {
    public static abstract class LeaveRequestHandler {
        protected LeaveRequestHandler nextHandler;

        public void setNextHandler(LeaveRequestHandler nextHandler) {
            this.nextHandler = nextHandler;
        }

        public abstract void handleRequest(LeaveRequest request);
    }
    public static class Manager extends LeaveRequestHandler {
        public void handleRequest(LeaveRequest request) {
            if (request.getLeaveDays() <= 2) {
                System.out.println("Manager approves " + request.getLeaveDays() + " days leave.");
            } else {
                if (nextHandler != null) {
                    nextHandler.handleRequest(request);
                }
            }
        }
    }

    public static class Director extends LeaveRequestHandler {
        public void handleRequest(LeaveRequest request) {
            if (request.getLeaveDays() <= 5) {
                System.out.println("Director approves " + request.getLeaveDays() + " days leave.");
            } else {
                if (nextHandler != null) {
                    nextHandler.handleRequest(request);
                }
            }
        }
    }

    public  static class HR extends LeaveRequestHandler {
        public void handleRequest(LeaveRequest request) {
            if (request.getLeaveDays() > 5) {
                System.out.println("HR approves " + request.getLeaveDays() + " days leave.");
            } else {
                if (nextHandler != null) {
                    nextHandler.handleRequest(request);
                }
            }
        }
    }
    public static class LeaveRequest {
        private int leaveDays;

        public LeaveRequest(int leaveDays) {
            this.leaveDays = leaveDays;
        }

        public int getLeaveDays() {
            return leaveDays;
        }
    }
        public static void main(String[] args) {
            LeaveRequestHandler manager = new Manager();
            LeaveRequestHandler director = new Director();
            LeaveRequestHandler hr = new HR();

            manager.setNextHandler(director);
            director.setNextHandler(hr);

            LeaveRequest leaveRequest1 = new LeaveRequest(2); // Should be approved by Manager
            LeaveRequest leaveRequest2 = new LeaveRequest(4); // Should be approved by Director
            LeaveRequest leaveRequest3 = new LeaveRequest(7); // Should be approved by HR

            manager.handleRequest(leaveRequest1);
            manager.handleRequest(leaveRequest2);
            manager.handleRequest(leaveRequest3);
        }

}
