package main.logic;

import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.math.*;

/**
 * @author Chase P. Miller
 * @version Version
 * @since
 */

public class BooleanOps {
    public boolean tautology(boolean a, boolean b) {
        return true;
    }

    public boolean contradiction(boolean a, boolean b) {
        return false;
    }

    public boolean A(boolean a, boolean b) {
        return a;
    }

    public boolean notA(boolean a, boolean b) {
        return !a;
    }

    public boolean B(boolean a, boolean b) {
        return b;
    }

    public boolean notB(boolean a, boolean b) {
        return !b;
    }

    public boolean conjunction(boolean a, boolean b) {
        return a && b;
    }

    public boolean alternativeDenial(boolean a, boolean b) {
        return !(a && b);
    }

    public boolean disjunction(boolean a, boolean b) {
        return a || b;
    }

    public boolean jointDenial(boolean a, boolean b) {
        return !(a || b);
    }

    public boolean abjunction(boolean a, boolean b) {
        return (a && !b);
    }

    public boolean implication(boolean a, boolean b) {
        return (!a || b);
    }

    public boolean converseAbjunction(boolean a, boolean b) {
        return (!a && b);
    }

    public boolean converseImplication(boolean a, boolean b) {
        return (a || !b);
    }

    public boolean exclusiveDisjunction(boolean a, boolean b) {
        return (a ^ b);
    }

    public boolean biconditional(boolean a, boolean b) {
        return !(a ^ b);
    }
}