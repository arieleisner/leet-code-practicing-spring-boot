package com.ariel.eisner.practice.domain.port.in;

import java.util.List;

/**
 * Suppose you are given two lists of n points, one list p1, p2, ..., pn
 * on the line y = 0 and the other list q1, q2, ..., qn on the line y = 1.
 * Imagine a set of n line segments connecting each point pi to qi.
 * Write an algorithm to determine how many pairs of the line segments intersect.
 */
public interface IntersectingLineSegmentsUseCase {
    int calculate(List<Integer> p, List<Integer> q);
}
