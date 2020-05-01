package pl.dixu.checkersarchitecture.client;

import org.springframework.stereotype.Component;

@Component
class DialogPrinter {

    private final String PREFIX = "Incorrect move, ";

    public void notifyCorrectMove() {
        System.out.println("Move executed!");
    }

    public void outOfBoardError() {
        System.out.println(PREFIX + "selection was outside the board!");
    }

    public void noCheckerSelectedError() {
        System.out.println(PREFIX + "you selected empty space!");
    }

    public void notYourCheckerSelectedError() {
        System.out.println(PREFIX + "you selected not your checker!");
    }

    public void notValidMoveError() {
        System.out.println(PREFIX + "this checker cannot move that way!");
    }

    public void fieldBlockedError() {
        System.out.println(PREFIX + "this field is blocked!");
    }

    public void noStatusError() {
        System.out.println(PREFIX + "try again!");
    }


}
