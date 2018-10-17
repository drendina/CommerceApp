package com.sopra.populator;

public interface Populator<SOURCE, TARGET> {
    Object populate(SOURCE sorurce, TARGET target);
}
