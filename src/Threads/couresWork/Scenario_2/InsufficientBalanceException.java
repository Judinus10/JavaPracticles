package Threads.couresWork.Scenario_2;

public class InsufficientBalanceException extends RuntimeException {
  public InsufficientBalanceException(String message, int accountId, double attemptedAmount) {
    super(message + " [Account ID: " + accountId + ", Attempted Amount: " + attemptedAmount + "]");
  }
}
