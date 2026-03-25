package com.ariel.eisner.practice.domain.service;

import com.ariel.eisner.practice.domain.model.Coordinates;
import com.ariel.eisner.practice.domain.model.Segment;
import com.ariel.eisner.practice.domain.port.in.IntersectingLineSegmentsUseCase;

import java.util.ArrayList;
import java.util.List;

public class IntersectionLineSegmentsService implements IntersectingLineSegmentsUseCase {

    @Override
    public int calculate(List<Integer> p, List<Integer> q) {
        int counter = 0;
        List<Segment> segments = new ArrayList<>();

        for (int i = 0; i < p.size(); ++i) {
            Coordinates pi = new Coordinates(p.get(i), 0);
            Coordinates qi = new Coordinates(q.get(i), 1);
            segments.add(new Segment(pi, qi));
        }

        for (int i = 0; i < segments.size() - 1; ++i) {
            for (int j = i+1; j < segments.size(); ++j) {
                if (areIntersecting(segments.get(i), segments.get(j))) {
                    ++counter;
                }
            }
        }

        return counter;
    }

    /**
     * To check whether two line segments intersect, you typically use a geometric orientation test. Let’s define your segments:
     *
     * Segment 1: points A(x, y) to B(x, y)
     * Segment 2: points C(x, y) to D(x, y)
     *
     * 1. Key idea: Orientation (cross product)
     *
     * For three points P, Q, R, compute:
     *
     * orientation(P, Q, R) = (Qy - Py)(Rx - Px) - (Qx - Px)(Ry - Py)
     *
     * * = 0 → collinear
     * * 0 → clockwise
     * * < 0 → counterclockwise
     *
     * 2. General intersection condition
     *
     * Segments AB and CD intersect if:
     * * orientation(A, B, C) and orientation(A, B, D) are different, AND
     * * orientation(C, D, A) and orientation(C, D, B) are different
     *
     * 3. Special case (collinear overlap)
     *
     * If any orientation is 0, you must also check if the point lies on the segment:
     *
     * A point Q lies on segment PR if:
     * * min(Px, Rx) =< Qx =< max(Px, Rx)
     * * min(Py, Ry) =< Qy =< max(Py, Ry)
     *
     * 4. Full algorithm (step-by-step)
     *
     * Compute:
     * o1 = orientation(A, B, C)
     * o2 = orientation(A, B, D)
     * o3 = orientation(C, D, A)
     * o4 = orientation(C, D, B)
     *
     * If:
     * o1 != o2 AND o3 != o4 -> intersect
     *
     * Else -> X no intersection
     */
    private boolean areIntersecting(Segment segment1, Segment segment2) {
        Coordinates a = segment1.p1();
        Coordinates b = segment1.p2();
        Coordinates c = segment2.p1();
        Coordinates d = segment2.p2();
        int o1 = orientation(a, b, c);
        int o2 = orientation(a, b, d);
        int o3 = orientation(c, d, a);
        int o4 = orientation(c, d, b);

        return o1 * o2 < 0 && o3 * o4 < 0;
    }

    private int orientation(Coordinates p, Coordinates q, Coordinates r) {
        return ((q.y() - p.y()) * (r.x() - p.x())) - ((q.x() - p.x()) * (r.y() - p.y()));
    }
}
