package androidx.compose.ui.graphics.vector;

import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.vector.PathNode;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PathParser.kt */
@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\u001aX\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\tH\u0002\u001aX\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0018H\u0002\u001a\u001a\u0010\u001a\u001a\u00020\u0007*\b\u0012\u0004\u0012\u00020\u001c0\u001b2\b\b\u0002\u0010\u001d\u001a\u00020\u0007\u001a\r\u0010\u001e\u001a\u00020\t*\u00020\tH\u0082\b\"\u0014\u0010\u0000\u001a\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003¨\u0006\u001f"}, d2 = {"EmptyArray", "", "getEmptyArray", "()[F", "arcToBezier", "", "p", "Landroidx/compose/ui/graphics/Path;", "cx", "", "cy", "a", "b", "e1x", "e1y", "theta", "start", "sweep", "drawArc", "x0", "y0", "x1", "y1", "isMoreThanHalf", "", "isPositiveArc", "toPath", "", "Landroidx/compose/ui/graphics/vector/PathNode;", "target", "toRadians", "ui-graphics_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class PathParserKt {
    private static final float[] EmptyArray = new float[0];

    public static final float[] getEmptyArray() {
        return EmptyArray;
    }

    public static /* synthetic */ Path toPath$default(List list, Path path, int i, Object obj) {
        if ((i & 1) != 0) {
            path = AndroidPath_androidKt.Path();
        }
        return toPath(list, path);
    }

    public static final Path toPath(List<? extends PathNode> list, Path target) {
        int index$iv;
        PathNode node;
        List $this$fastForEach$iv;
        int i;
        int fillType;
        float reflectiveCtrlX;
        float reflectiveCtrlY;
        float reflectiveCtrlX2;
        float reflectiveCtrlY2;
        float reflectiveCtrlY3;
        float reflectiveCtrlX3;
        float reflectiveCtrlX4;
        float reflectiveCtrlY4;
        Path target2 = target;
        Intrinsics.checkNotNullParameter(list, "<this>");
        Intrinsics.checkNotNullParameter(target2, "target");
        int fillType2 = target.mo2842getFillTypeRgk1Os();
        target.rewind();
        target2.mo2844setFillTypeoQ8Xj4U(fillType2);
        PathNode pathNode = list.isEmpty() ? PathNode.Close.INSTANCE : list.get(0);
        List $this$fastForEach$iv2 = list;
        int size = $this$fastForEach$iv2.size();
        float currentY = 0.0f;
        float ctrlX = 0.0f;
        float ctrlY = 0.0f;
        float segmentX = 0.0f;
        float segmentY = 0.0f;
        PathNode pathNode2 = pathNode;
        int index$iv2 = 0;
        float currentX = 0.0f;
        while (index$iv2 < size) {
            Object item$iv = $this$fastForEach$iv2.get(index$iv2);
            PathNode node2 = (PathNode) item$iv;
            if (node2 instanceof PathNode.Close) {
                float currentX2 = segmentX;
                float currentY2 = segmentY;
                float ctrlX2 = segmentX;
                float ctrlY2 = segmentY;
                target.close();
                target2.moveTo(currentX2, currentY2);
                currentX = currentX2;
                currentY = currentY2;
                ctrlX = ctrlX2;
                ctrlY = ctrlY2;
                index$iv = index$iv2;
                node = node2;
                $this$fastForEach$iv = $this$fastForEach$iv2;
                i = size;
                fillType = fillType2;
            } else if (node2 instanceof PathNode.RelativeMoveTo) {
                currentX += ((PathNode.RelativeMoveTo) node2).getDx();
                currentY += ((PathNode.RelativeMoveTo) node2).getDy();
                target2.relativeMoveTo(((PathNode.RelativeMoveTo) node2).getDx(), ((PathNode.RelativeMoveTo) node2).getDy());
                segmentX = currentX;
                segmentY = currentY;
                index$iv = index$iv2;
                node = node2;
                $this$fastForEach$iv = $this$fastForEach$iv2;
                i = size;
                fillType = fillType2;
            } else if (node2 instanceof PathNode.MoveTo) {
                float currentX3 = ((PathNode.MoveTo) node2).getX();
                float currentY3 = ((PathNode.MoveTo) node2).getY();
                target2.moveTo(((PathNode.MoveTo) node2).getX(), ((PathNode.MoveTo) node2).getY());
                currentX = currentX3;
                currentY = currentY3;
                segmentX = currentX3;
                segmentY = currentY3;
                index$iv = index$iv2;
                node = node2;
                $this$fastForEach$iv = $this$fastForEach$iv2;
                i = size;
                fillType = fillType2;
            } else if (node2 instanceof PathNode.RelativeLineTo) {
                target2.relativeLineTo(((PathNode.RelativeLineTo) node2).getDx(), ((PathNode.RelativeLineTo) node2).getDy());
                currentX += ((PathNode.RelativeLineTo) node2).getDx();
                currentY += ((PathNode.RelativeLineTo) node2).getDy();
                index$iv = index$iv2;
                node = node2;
                $this$fastForEach$iv = $this$fastForEach$iv2;
                i = size;
                fillType = fillType2;
            } else if (node2 instanceof PathNode.LineTo) {
                target2.lineTo(((PathNode.LineTo) node2).getX(), ((PathNode.LineTo) node2).getY());
                float currentX4 = ((PathNode.LineTo) node2).getX();
                currentX = currentX4;
                currentY = ((PathNode.LineTo) node2).getY();
                index$iv = index$iv2;
                node = node2;
                $this$fastForEach$iv = $this$fastForEach$iv2;
                i = size;
                fillType = fillType2;
            } else if (node2 instanceof PathNode.RelativeHorizontalTo) {
                target2.relativeLineTo(((PathNode.RelativeHorizontalTo) node2).getDx(), 0.0f);
                currentX += ((PathNode.RelativeHorizontalTo) node2).getDx();
                index$iv = index$iv2;
                node = node2;
                $this$fastForEach$iv = $this$fastForEach$iv2;
                i = size;
                fillType = fillType2;
            } else if (node2 instanceof PathNode.HorizontalTo) {
                target2.lineTo(((PathNode.HorizontalTo) node2).getX(), currentY);
                currentX = ((PathNode.HorizontalTo) node2).getX();
                index$iv = index$iv2;
                node = node2;
                $this$fastForEach$iv = $this$fastForEach$iv2;
                i = size;
                fillType = fillType2;
            } else if (node2 instanceof PathNode.RelativeVerticalTo) {
                target2.relativeLineTo(0.0f, ((PathNode.RelativeVerticalTo) node2).getDy());
                currentY += ((PathNode.RelativeVerticalTo) node2).getDy();
                index$iv = index$iv2;
                node = node2;
                $this$fastForEach$iv = $this$fastForEach$iv2;
                i = size;
                fillType = fillType2;
            } else if (node2 instanceof PathNode.VerticalTo) {
                target2.lineTo(currentX, ((PathNode.VerticalTo) node2).getY());
                currentY = ((PathNode.VerticalTo) node2).getY();
                index$iv = index$iv2;
                node = node2;
                $this$fastForEach$iv = $this$fastForEach$iv2;
                i = size;
                fillType = fillType2;
            } else if (node2 instanceof PathNode.RelativeCurveTo) {
                target.relativeCubicTo(((PathNode.RelativeCurveTo) node2).getDx1(), ((PathNode.RelativeCurveTo) node2).getDy1(), ((PathNode.RelativeCurveTo) node2).getDx2(), ((PathNode.RelativeCurveTo) node2).getDy2(), ((PathNode.RelativeCurveTo) node2).getDx3(), ((PathNode.RelativeCurveTo) node2).getDy3());
                float ctrlX3 = ((PathNode.RelativeCurveTo) node2).getDx2() + currentX;
                float ctrlY3 = ((PathNode.RelativeCurveTo) node2).getDy2() + currentY;
                currentX += ((PathNode.RelativeCurveTo) node2).getDx3();
                currentY += ((PathNode.RelativeCurveTo) node2).getDy3();
                ctrlX = ctrlX3;
                ctrlY = ctrlY3;
                index$iv = index$iv2;
                node = node2;
                $this$fastForEach$iv = $this$fastForEach$iv2;
                i = size;
                fillType = fillType2;
            } else if (node2 instanceof PathNode.CurveTo) {
                target.cubicTo(((PathNode.CurveTo) node2).getX1(), ((PathNode.CurveTo) node2).getY1(), ((PathNode.CurveTo) node2).getX2(), ((PathNode.CurveTo) node2).getY2(), ((PathNode.CurveTo) node2).getX3(), ((PathNode.CurveTo) node2).getY3());
                float ctrlX4 = ((PathNode.CurveTo) node2).getX2();
                float ctrlY4 = ((PathNode.CurveTo) node2).getY2();
                float currentX5 = ((PathNode.CurveTo) node2).getX3();
                ctrlX = ctrlX4;
                ctrlY = ctrlY4;
                currentX = currentX5;
                currentY = ((PathNode.CurveTo) node2).getY3();
                index$iv = index$iv2;
                node = node2;
                $this$fastForEach$iv = $this$fastForEach$iv2;
                i = size;
                fillType = fillType2;
            } else if (node2 instanceof PathNode.RelativeReflectiveCurveTo) {
                if (pathNode2.getIsCurve()) {
                    float reflectiveCtrlX5 = currentX - ctrlX;
                    reflectiveCtrlX4 = reflectiveCtrlX5;
                    reflectiveCtrlY4 = currentY - ctrlY;
                } else {
                    reflectiveCtrlX4 = 0.0f;
                    reflectiveCtrlY4 = 0.0f;
                }
                target.relativeCubicTo(reflectiveCtrlX4, reflectiveCtrlY4, ((PathNode.RelativeReflectiveCurveTo) node2).getDx1(), ((PathNode.RelativeReflectiveCurveTo) node2).getDy1(), ((PathNode.RelativeReflectiveCurveTo) node2).getDx2(), ((PathNode.RelativeReflectiveCurveTo) node2).getDy2());
                float ctrlX5 = ((PathNode.RelativeReflectiveCurveTo) node2).getDx1() + currentX;
                float ctrlY5 = ((PathNode.RelativeReflectiveCurveTo) node2).getDy1() + currentY;
                currentX += ((PathNode.RelativeReflectiveCurveTo) node2).getDx2();
                currentY += ((PathNode.RelativeReflectiveCurveTo) node2).getDy2();
                ctrlX = ctrlX5;
                ctrlY = ctrlY5;
                index$iv = index$iv2;
                node = node2;
                $this$fastForEach$iv = $this$fastForEach$iv2;
                i = size;
                fillType = fillType2;
            } else if (node2 instanceof PathNode.ReflectiveCurveTo) {
                if (pathNode2.getIsCurve()) {
                    float f = 2;
                    float reflectiveCtrlX6 = (f * currentX) - ctrlX;
                    reflectiveCtrlY3 = (f * currentY) - ctrlY;
                    reflectiveCtrlX3 = reflectiveCtrlX6;
                } else {
                    float reflectiveCtrlX7 = currentX;
                    reflectiveCtrlY3 = currentY;
                    reflectiveCtrlX3 = reflectiveCtrlX7;
                }
                target.cubicTo(reflectiveCtrlX3, reflectiveCtrlY3, ((PathNode.ReflectiveCurveTo) node2).getX1(), ((PathNode.ReflectiveCurveTo) node2).getY1(), ((PathNode.ReflectiveCurveTo) node2).getX2(), ((PathNode.ReflectiveCurveTo) node2).getY2());
                float ctrlX6 = ((PathNode.ReflectiveCurveTo) node2).getX1();
                float ctrlY6 = ((PathNode.ReflectiveCurveTo) node2).getY1();
                float currentX6 = ((PathNode.ReflectiveCurveTo) node2).getX2();
                ctrlX = ctrlX6;
                ctrlY = ctrlY6;
                currentX = currentX6;
                currentY = ((PathNode.ReflectiveCurveTo) node2).getY2();
                index$iv = index$iv2;
                node = node2;
                $this$fastForEach$iv = $this$fastForEach$iv2;
                i = size;
                fillType = fillType2;
            } else if (node2 instanceof PathNode.RelativeQuadTo) {
                target2.relativeQuadraticBezierTo(((PathNode.RelativeQuadTo) node2).getDx1(), ((PathNode.RelativeQuadTo) node2).getDy1(), ((PathNode.RelativeQuadTo) node2).getDx2(), ((PathNode.RelativeQuadTo) node2).getDy2());
                float ctrlX7 = ((PathNode.RelativeQuadTo) node2).getDx1() + currentX;
                float ctrlY7 = ((PathNode.RelativeQuadTo) node2).getDy1() + currentY;
                currentX += ((PathNode.RelativeQuadTo) node2).getDx2();
                currentY += ((PathNode.RelativeQuadTo) node2).getDy2();
                ctrlX = ctrlX7;
                ctrlY = ctrlY7;
                index$iv = index$iv2;
                node = node2;
                $this$fastForEach$iv = $this$fastForEach$iv2;
                i = size;
                fillType = fillType2;
            } else if (node2 instanceof PathNode.QuadTo) {
                target2.quadraticBezierTo(((PathNode.QuadTo) node2).getX1(), ((PathNode.QuadTo) node2).getY1(), ((PathNode.QuadTo) node2).getX2(), ((PathNode.QuadTo) node2).getY2());
                float ctrlX8 = ((PathNode.QuadTo) node2).getX1();
                float ctrlY8 = ((PathNode.QuadTo) node2).getY1();
                float currentX7 = ((PathNode.QuadTo) node2).getX2();
                ctrlX = ctrlX8;
                ctrlY = ctrlY8;
                currentX = currentX7;
                currentY = ((PathNode.QuadTo) node2).getY2();
                index$iv = index$iv2;
                node = node2;
                $this$fastForEach$iv = $this$fastForEach$iv2;
                i = size;
                fillType = fillType2;
            } else if (node2 instanceof PathNode.RelativeReflectiveQuadTo) {
                if (pathNode2.getIsQuad()) {
                    reflectiveCtrlX2 = currentX - ctrlX;
                    reflectiveCtrlY2 = currentY - ctrlY;
                } else {
                    reflectiveCtrlX2 = 0.0f;
                    reflectiveCtrlY2 = 0.0f;
                }
                target2.relativeQuadraticBezierTo(reflectiveCtrlX2, reflectiveCtrlY2, ((PathNode.RelativeReflectiveQuadTo) node2).getDx(), ((PathNode.RelativeReflectiveQuadTo) node2).getDy());
                float ctrlX9 = currentX + reflectiveCtrlX2;
                float ctrlY9 = currentY + reflectiveCtrlY2;
                currentX += ((PathNode.RelativeReflectiveQuadTo) node2).getDx();
                currentY += ((PathNode.RelativeReflectiveQuadTo) node2).getDy();
                ctrlX = ctrlX9;
                ctrlY = ctrlY9;
                index$iv = index$iv2;
                node = node2;
                $this$fastForEach$iv = $this$fastForEach$iv2;
                i = size;
                fillType = fillType2;
            } else if (node2 instanceof PathNode.ReflectiveQuadTo) {
                if (pathNode2.getIsQuad()) {
                    float f2 = 2;
                    reflectiveCtrlX = (f2 * currentX) - ctrlX;
                    reflectiveCtrlY = (f2 * currentY) - ctrlY;
                } else {
                    reflectiveCtrlX = currentX;
                    reflectiveCtrlY = currentY;
                }
                target2.quadraticBezierTo(reflectiveCtrlX, reflectiveCtrlY, ((PathNode.ReflectiveQuadTo) node2).getX(), ((PathNode.ReflectiveQuadTo) node2).getY());
                float ctrlX10 = reflectiveCtrlX;
                float ctrlY10 = reflectiveCtrlY;
                float currentX8 = ((PathNode.ReflectiveQuadTo) node2).getX();
                ctrlX = ctrlX10;
                ctrlY = ctrlY10;
                currentX = currentX8;
                currentY = ((PathNode.ReflectiveQuadTo) node2).getY();
                index$iv = index$iv2;
                node = node2;
                $this$fastForEach$iv = $this$fastForEach$iv2;
                i = size;
                fillType = fillType2;
            } else if (node2 instanceof PathNode.RelativeArcTo) {
                float arcStartX = ((PathNode.RelativeArcTo) node2).getArcStartDx() + currentX;
                float arcStartY = ((PathNode.RelativeArcTo) node2).getArcStartDy() + currentY;
                index$iv = index$iv2;
                node = node2;
                double horizontalEllipseRadius = ((PathNode.RelativeArcTo) node).getHorizontalEllipseRadius();
                float currentY4 = ((PathNode.RelativeArcTo) node).getVerticalEllipseRadius();
                $this$fastForEach$iv = $this$fastForEach$iv2;
                i = size;
                fillType = fillType2;
                drawArc(target, currentX, currentY, arcStartX, arcStartY, horizontalEllipseRadius, currentY4, ((PathNode.RelativeArcTo) node).getTheta(), ((PathNode.RelativeArcTo) node).isMoreThanHalf(), ((PathNode.RelativeArcTo) node).isPositiveArc());
                currentX = arcStartX;
                currentY = arcStartY;
                ctrlX = arcStartX;
                ctrlY = arcStartY;
            } else {
                index$iv = index$iv2;
                node = node2;
                float currentX9 = currentX;
                float currentY5 = currentY;
                $this$fastForEach$iv = $this$fastForEach$iv2;
                i = size;
                fillType = fillType2;
                if (!(node instanceof PathNode.ArcTo)) {
                    currentY = currentY5;
                    currentX = currentX9;
                } else {
                    drawArc(target, currentX9, currentY5, ((PathNode.ArcTo) node).getArcStartX(), ((PathNode.ArcTo) node).getArcStartY(), ((PathNode.ArcTo) node).getHorizontalEllipseRadius(), ((PathNode.ArcTo) node).getVerticalEllipseRadius(), ((PathNode.ArcTo) node).getTheta(), ((PathNode.ArcTo) node).isMoreThanHalf(), ((PathNode.ArcTo) node).isPositiveArc());
                    float currentX10 = ((PathNode.ArcTo) node).getArcStartX();
                    float currentY6 = ((PathNode.ArcTo) node).getArcStartY();
                    currentX = currentX10;
                    currentY = currentY6;
                    ctrlX = currentX10;
                    ctrlY = currentY6;
                }
            }
            pathNode2 = node;
            index$iv2 = index$iv + 1;
            target2 = target;
            $this$fastForEach$iv2 = $this$fastForEach$iv;
            size = i;
            fillType2 = fillType;
        }
        return target;
    }

    private static final void drawArc(Path p, double x0, double y0, double x1, double y1, double a, double b, double theta, boolean isMoreThanHalf, boolean isPositiveArc) {
        double cx;
        double cy;
        double thetaD = (theta / 180) * 3.141592653589793d;
        double cosTheta = Math.cos(thetaD);
        double sinTheta = Math.sin(thetaD);
        double x0p = ((x0 * cosTheta) + (y0 * sinTheta)) / a;
        double y0p = (((-x0) * sinTheta) + (y0 * cosTheta)) / b;
        double x1p = ((x1 * cosTheta) + (y1 * sinTheta)) / a;
        double y1p = (((-x1) * sinTheta) + (y1 * cosTheta)) / b;
        double dx = x0p - x1p;
        double dy = y0p - y1p;
        double d = 2;
        double xm = (x0p + x1p) / d;
        double ym = (y0p + y1p) / d;
        double dsq = (dx * dx) + (dy * dy);
        if (dsq == 0.0d) {
            return;
        }
        double disc = (1.0d / dsq) - 0.25d;
        if (disc < 0.0d) {
            float adjust = (float) (Math.sqrt(dsq) / 1.99999d);
            drawArc(p, x0, y0, x1, y1, a * adjust, b * adjust, theta, isMoreThanHalf, isPositiveArc);
            return;
        }
        double s = Math.sqrt(disc);
        double sdx = s * dx;
        double sdy = s * dy;
        if (isMoreThanHalf == isPositiveArc) {
            cx = xm - sdy;
            cy = ym + sdx;
        } else {
            cx = xm + sdy;
            cy = ym - sdx;
        }
        double eta0 = Math.atan2(y0p - cy, x0p - cx);
        double eta1 = Math.atan2(y1p - cy, x1p - cx);
        double sweep = eta1 - eta0;
        if (isPositiveArc != (sweep >= 0.0d)) {
            if (sweep > 0.0d) {
                sweep -= 6.283185307179586d;
            } else {
                sweep += 6.283185307179586d;
            }
        }
        double cx2 = cx * a;
        double cy2 = cy * b;
        arcToBezier(p, (cx2 * cosTheta) - (cy2 * sinTheta), (cx2 * sinTheta) + (cy2 * cosTheta), a, b, x0, y0, thetaD, eta0, sweep);
    }

    private static final void arcToBezier(Path p, double cx, double cy, double a, double b, double e1x, double e1y, double theta, double start, double sweep) {
        double eta1 = a;
        double eta1y = e1y;
        double d = 4;
        int numSegments = (int) Math.ceil(Math.abs((sweep * d) / 3.141592653589793d));
        double eta12 = start;
        double cosTheta = Math.cos(theta);
        double sinTheta = Math.sin(theta);
        double cosEta1 = Math.cos(eta12);
        double sinEta1 = Math.sin(eta12);
        double eta1x = e1x;
        double eta1x2 = -eta1;
        double ep1x = ((eta1x2 * cosTheta) * sinEta1) - ((b * sinTheta) * cosEta1);
        double ep1x2 = ep1x;
        double ep1x3 = -eta1;
        double ep1y = (ep1x3 * sinTheta * sinEta1) + (b * cosTheta * cosEta1);
        double ep1y2 = ep1y;
        double ep1y3 = numSegments;
        double anglePerSegment = sweep / ep1y3;
        int i = 0;
        while (i < numSegments) {
            double eta2 = eta12 + anglePerSegment;
            double sinEta2 = Math.sin(eta2);
            double cosEta2 = Math.cos(eta2);
            double anglePerSegment2 = anglePerSegment;
            double anglePerSegment3 = (cx + ((eta1 * cosTheta) * cosEta2)) - ((b * sinTheta) * sinEta2);
            double e2x = cy + (eta1 * sinTheta * cosEta2) + (b * cosTheta * sinEta2);
            double e2y = -eta1;
            double ep2x = ((e2y * cosTheta) * sinEta2) - ((b * sinTheta) * cosEta2);
            double ep2y = ((-eta1) * sinTheta * sinEta2) + (b * cosTheta * cosEta2);
            double tanDiff2 = Math.tan((eta2 - eta12) / 2);
            double alpha = (Math.sin(eta2 - eta12) * (Math.sqrt(d + ((3.0d * tanDiff2) * tanDiff2)) - 1)) / 3;
            double q1x = eta1x + (alpha * ep1x2);
            double d2 = d;
            double q1y = eta1y + (alpha * ep1y2);
            double eta1y2 = anglePerSegment3 - (alpha * ep2x);
            int numSegments2 = numSegments;
            double q2y = e2x - (alpha * ep2y);
            double e2y2 = cosTheta;
            p.cubicTo((float) q1x, (float) q1y, (float) eta1y2, (float) q2y, (float) anglePerSegment3, (float) e2x);
            eta1x = anglePerSegment3;
            ep1x2 = ep2x;
            ep1y2 = ep2y;
            i++;
            eta1y = e2x;
            numSegments = numSegments2;
            cosTheta = e2y2;
            anglePerSegment = anglePerSegment2;
            d = d2;
            eta12 = eta2;
            eta1 = a;
        }
    }

    private static final double toRadians(double $this$toRadians) {
        return ($this$toRadians / 180) * 3.141592653589793d;
    }
}
