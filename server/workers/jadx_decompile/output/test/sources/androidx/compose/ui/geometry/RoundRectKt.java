package androidx.compose.ui.geometry;

import androidx.compose.ui.util.MathHelpersKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RoundRect.kt */
@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0019\u001a#\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u00012\u0006\u0010\u001b\u001a\u00020\u001cø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u001e\u001aC\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u00012\b\b\u0002\u0010\u001f\u001a\u00020\u001c2\b\b\u0002\u0010 \u001a\u00020\u001c2\b\b\u0002\u0010!\u001a\u00020\u001c2\b\b\u0002\u0010\"\u001a\u00020\u001cø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b#\u0010$\u001a\u001e\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u00012\u0006\u0010%\u001a\u00020\u00122\u0006\u0010&\u001a\u00020\u0012\u001a;\u0010\u0019\u001a\u00020\u00022\u0006\u0010'\u001a\u00020\u00122\u0006\u0010(\u001a\u00020\u00122\u0006\u0010)\u001a\u00020\u00122\u0006\u0010*\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\u001cø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b+\u0010,\u001a6\u0010\u0019\u001a\u00020\u00022\u0006\u0010'\u001a\u00020\u00122\u0006\u0010(\u001a\u00020\u00122\u0006\u0010)\u001a\u00020\u00122\u0006\u0010*\u001a\u00020\u00122\u0006\u0010%\u001a\u00020\u00122\u0006\u0010&\u001a\u00020\u0012\u001a\u001e\u0010-\u001a\u00020\u00022\u0006\u0010.\u001a\u00020\u00022\u0006\u0010/\u001a\u00020\u00022\u0006\u00100\u001a\u00020\u0012\u001a\u001f\u00101\u001a\u00020\u0002*\u00020\u00022\u0006\u00102\u001a\u00020\u0006ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b3\u00104\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u0018\u0010\u0005\u001a\u00020\u0006*\u00020\u00028Fø\u0001\u0000¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b\"\u0015\u0010\t\u001a\u00020\n*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\t\u0010\u000b\"\u0015\u0010\f\u001a\u00020\n*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\f\u0010\u000b\"\u0015\u0010\r\u001a\u00020\n*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\r\u0010\u000b\"\u0015\u0010\u000e\u001a\u00020\n*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000b\"\u0015\u0010\u000f\u001a\u00020\n*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u000b\"\u0015\u0010\u0010\u001a\u00020\n*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u000b\"\u0015\u0010\u0011\u001a\u00020\u0012*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014\"\u0015\u0010\u0015\u001a\u00020\u0012*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0014\"\u0015\u0010\u0017\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0004\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u00065"}, d2 = {"boundingRect", "Landroidx/compose/ui/geometry/Rect;", "Landroidx/compose/ui/geometry/RoundRect;", "getBoundingRect", "(Landroidx/compose/ui/geometry/RoundRect;)Landroidx/compose/ui/geometry/Rect;", "center", "Landroidx/compose/ui/geometry/Offset;", "getCenter", "(Landroidx/compose/ui/geometry/RoundRect;)J", "isCircle", "", "(Landroidx/compose/ui/geometry/RoundRect;)Z", "isEllipse", "isEmpty", "isFinite", "isRect", "isSimple", "maxDimension", "", "getMaxDimension", "(Landroidx/compose/ui/geometry/RoundRect;)F", "minDimension", "getMinDimension", "safeInnerRect", "getSafeInnerRect", "RoundRect", "rect", "cornerRadius", "Landroidx/compose/ui/geometry/CornerRadius;", "RoundRect-sniSvfs", "(Landroidx/compose/ui/geometry/Rect;J)Landroidx/compose/ui/geometry/RoundRect;", "topLeft", "topRight", "bottomRight", "bottomLeft", "RoundRect-ZAM2FJo", "(Landroidx/compose/ui/geometry/Rect;JJJJ)Landroidx/compose/ui/geometry/RoundRect;", "radiusX", "radiusY", "left", "top", "right", "bottom", "RoundRect-gG7oq9Y", "(FFFFJ)Landroidx/compose/ui/geometry/RoundRect;", "lerp", "start", "stop", "fraction", "translate", "offset", "translate-Uv8p0NA", "(Landroidx/compose/ui/geometry/RoundRect;J)Landroidx/compose/ui/geometry/RoundRect;", "ui-geometry_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class RoundRectKt {
    public static final RoundRect RoundRect(float left, float top, float right, float bottom, float radiusX, float radiusY) {
        long radius = CornerRadiusKt.CornerRadius(radiusX, radiusY);
        return new RoundRect(left, top, right, bottom, radius, radius, radius, radius, null);
    }

    /* renamed from: RoundRect-gG7oq9Y, reason: not valid java name */
    public static final RoundRect m2764RoundRectgG7oq9Y(float left, float top, float right, float bottom, long cornerRadius) {
        return RoundRect(left, top, right, bottom, CornerRadius.m2685getXimpl(cornerRadius), CornerRadius.m2686getYimpl(cornerRadius));
    }

    public static final RoundRect RoundRect(Rect rect, float radiusX, float radiusY) {
        Intrinsics.checkNotNullParameter(rect, "rect");
        return RoundRect(rect.getLeft(), rect.getTop(), rect.getRight(), rect.getBottom(), radiusX, radiusY);
    }

    /* renamed from: RoundRect-sniSvfs, reason: not valid java name */
    public static final RoundRect m2765RoundRectsniSvfs(Rect rect, long cornerRadius) {
        Intrinsics.checkNotNullParameter(rect, "rect");
        return RoundRect(rect, CornerRadius.m2685getXimpl(cornerRadius), CornerRadius.m2686getYimpl(cornerRadius));
    }

    /* renamed from: RoundRect-ZAM2FJo, reason: not valid java name */
    public static final RoundRect m2762RoundRectZAM2FJo(Rect rect, long topLeft, long topRight, long bottomRight, long bottomLeft) {
        Intrinsics.checkNotNullParameter(rect, "rect");
        return new RoundRect(rect.getLeft(), rect.getTop(), rect.getRight(), rect.getBottom(), topLeft, topRight, bottomRight, bottomLeft, null);
    }

    /* renamed from: translate-Uv8p0NA, reason: not valid java name */
    public static final RoundRect m2766translateUv8p0NA(RoundRect translate, long offset) {
        Intrinsics.checkNotNullParameter(translate, "$this$translate");
        return new RoundRect(Offset.m2710getXimpl(offset) + translate.getLeft(), Offset.m2711getYimpl(offset) + translate.getTop(), Offset.m2710getXimpl(offset) + translate.getRight(), Offset.m2711getYimpl(offset) + translate.getBottom(), translate.m2760getTopLeftCornerRadiuskKHJgLs(), translate.m2761getTopRightCornerRadiuskKHJgLs(), translate.m2759getBottomRightCornerRadiuskKHJgLs(), translate.m2758getBottomLeftCornerRadiuskKHJgLs(), null);
    }

    public static final Rect getBoundingRect(RoundRect $this$boundingRect) {
        Intrinsics.checkNotNullParameter($this$boundingRect, "<this>");
        return new Rect($this$boundingRect.getLeft(), $this$boundingRect.getTop(), $this$boundingRect.getRight(), $this$boundingRect.getBottom());
    }

    public static final Rect getSafeInnerRect(RoundRect $this$safeInnerRect) {
        Intrinsics.checkNotNullParameter($this$safeInnerRect, "<this>");
        float leftRadius = Math.max(CornerRadius.m2685getXimpl($this$safeInnerRect.m2758getBottomLeftCornerRadiuskKHJgLs()), CornerRadius.m2685getXimpl($this$safeInnerRect.m2760getTopLeftCornerRadiuskKHJgLs()));
        float topRadius = Math.max(CornerRadius.m2686getYimpl($this$safeInnerRect.m2760getTopLeftCornerRadiuskKHJgLs()), CornerRadius.m2686getYimpl($this$safeInnerRect.m2761getTopRightCornerRadiuskKHJgLs()));
        float rightRadius = Math.max(CornerRadius.m2685getXimpl($this$safeInnerRect.m2761getTopRightCornerRadiuskKHJgLs()), CornerRadius.m2685getXimpl($this$safeInnerRect.m2759getBottomRightCornerRadiuskKHJgLs()));
        float bottomRadius = Math.max(CornerRadius.m2686getYimpl($this$safeInnerRect.m2759getBottomRightCornerRadiuskKHJgLs()), CornerRadius.m2686getYimpl($this$safeInnerRect.m2758getBottomLeftCornerRadiuskKHJgLs()));
        return new Rect($this$safeInnerRect.getLeft() + (leftRadius * 0.29289323f), $this$safeInnerRect.getTop() + (topRadius * 0.29289323f), $this$safeInnerRect.getRight() - (rightRadius * 0.29289323f), $this$safeInnerRect.getBottom() - (bottomRadius * 0.29289323f));
    }

    public static final boolean isEmpty(RoundRect $this$isEmpty) {
        Intrinsics.checkNotNullParameter($this$isEmpty, "<this>");
        return $this$isEmpty.getLeft() >= $this$isEmpty.getRight() || $this$isEmpty.getTop() >= $this$isEmpty.getBottom();
    }

    public static final boolean isFinite(RoundRect $this$isFinite) {
        Intrinsics.checkNotNullParameter($this$isFinite, "<this>");
        float left = $this$isFinite.getLeft();
        if ((Float.isInfinite(left) || Float.isNaN(left)) ? false : true) {
            float top = $this$isFinite.getTop();
            if ((Float.isInfinite(top) || Float.isNaN(top)) ? false : true) {
                float right = $this$isFinite.getRight();
                if ((Float.isInfinite(right) || Float.isNaN(right)) ? false : true) {
                    float bottom = $this$isFinite.getBottom();
                    if ((Float.isInfinite(bottom) || Float.isNaN(bottom)) ? false : true) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x004a, code lost:
    
        if ((androidx.compose.ui.geometry.CornerRadius.m2686getYimpl(r6.m2761getTopRightCornerRadiuskKHJgLs()) == 0.0f) != false) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x006c, code lost:
    
        if ((androidx.compose.ui.geometry.CornerRadius.m2686getYimpl(r6.m2758getBottomLeftCornerRadiuskKHJgLs()) == 0.0f) != false) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0028, code lost:
    
        if ((androidx.compose.ui.geometry.CornerRadius.m2686getYimpl(r6.m2760getTopLeftCornerRadiuskKHJgLs()) == 0.0f) != false) goto L12;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final boolean isRect(androidx.compose.ui.geometry.RoundRect r6) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            long r0 = r6.m2760getTopLeftCornerRadiuskKHJgLs()
            float r0 = androidx.compose.ui.geometry.CornerRadius.m2685getXimpl(r0)
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            r2 = 1
            r3 = 0
            if (r0 != 0) goto L16
            r0 = r2
            goto L17
        L16:
            r0 = r3
        L17:
            if (r0 != 0) goto L2a
            long r4 = r6.m2760getTopLeftCornerRadiuskKHJgLs()
            float r0 = androidx.compose.ui.geometry.CornerRadius.m2686getYimpl(r4)
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 != 0) goto L27
            r0 = r2
            goto L28
        L27:
            r0 = r3
        L28:
            if (r0 == 0) goto L91
        L2a:
            long r4 = r6.m2761getTopRightCornerRadiuskKHJgLs()
            float r0 = androidx.compose.ui.geometry.CornerRadius.m2685getXimpl(r4)
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 != 0) goto L38
            r0 = r2
            goto L39
        L38:
            r0 = r3
        L39:
            if (r0 != 0) goto L4c
            long r4 = r6.m2761getTopRightCornerRadiuskKHJgLs()
            float r0 = androidx.compose.ui.geometry.CornerRadius.m2686getYimpl(r4)
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 != 0) goto L49
            r0 = r2
            goto L4a
        L49:
            r0 = r3
        L4a:
            if (r0 == 0) goto L91
        L4c:
            long r4 = r6.m2758getBottomLeftCornerRadiuskKHJgLs()
            float r0 = androidx.compose.ui.geometry.CornerRadius.m2685getXimpl(r4)
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 != 0) goto L5a
            r0 = r2
            goto L5b
        L5a:
            r0 = r3
        L5b:
            if (r0 != 0) goto L6e
            long r4 = r6.m2758getBottomLeftCornerRadiuskKHJgLs()
            float r0 = androidx.compose.ui.geometry.CornerRadius.m2686getYimpl(r4)
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 != 0) goto L6b
            r0 = r2
            goto L6c
        L6b:
            r0 = r3
        L6c:
            if (r0 == 0) goto L91
        L6e:
            long r4 = r6.m2759getBottomRightCornerRadiuskKHJgLs()
            float r0 = androidx.compose.ui.geometry.CornerRadius.m2685getXimpl(r4)
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 != 0) goto L7c
            r0 = r2
            goto L7d
        L7c:
            r0 = r3
        L7d:
            if (r0 != 0) goto L92
            long r4 = r6.m2759getBottomRightCornerRadiuskKHJgLs()
            float r0 = androidx.compose.ui.geometry.CornerRadius.m2686getYimpl(r4)
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 != 0) goto L8d
            r0 = r2
            goto L8e
        L8d:
            r0 = r3
        L8e:
            if (r0 == 0) goto L91
            goto L92
        L91:
            r2 = r3
        L92:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.geometry.RoundRectKt.isRect(androidx.compose.ui.geometry.RoundRect):boolean");
    }

    public static final boolean isEllipse(RoundRect $this$isEllipse) {
        Intrinsics.checkNotNullParameter($this$isEllipse, "<this>");
        if (CornerRadius.m2685getXimpl($this$isEllipse.m2760getTopLeftCornerRadiuskKHJgLs()) == CornerRadius.m2685getXimpl($this$isEllipse.m2761getTopRightCornerRadiuskKHJgLs())) {
            if (CornerRadius.m2686getYimpl($this$isEllipse.m2760getTopLeftCornerRadiuskKHJgLs()) == CornerRadius.m2686getYimpl($this$isEllipse.m2761getTopRightCornerRadiuskKHJgLs())) {
                if (CornerRadius.m2685getXimpl($this$isEllipse.m2761getTopRightCornerRadiuskKHJgLs()) == CornerRadius.m2685getXimpl($this$isEllipse.m2759getBottomRightCornerRadiuskKHJgLs())) {
                    if (CornerRadius.m2686getYimpl($this$isEllipse.m2761getTopRightCornerRadiuskKHJgLs()) == CornerRadius.m2686getYimpl($this$isEllipse.m2759getBottomRightCornerRadiuskKHJgLs())) {
                        if (CornerRadius.m2685getXimpl($this$isEllipse.m2759getBottomRightCornerRadiuskKHJgLs()) == CornerRadius.m2685getXimpl($this$isEllipse.m2758getBottomLeftCornerRadiuskKHJgLs())) {
                            if ((CornerRadius.m2686getYimpl($this$isEllipse.m2759getBottomRightCornerRadiuskKHJgLs()) == CornerRadius.m2686getYimpl($this$isEllipse.m2758getBottomLeftCornerRadiuskKHJgLs())) && $this$isEllipse.getWidth() <= CornerRadius.m2685getXimpl($this$isEllipse.m2760getTopLeftCornerRadiuskKHJgLs()) * 2.0d && $this$isEllipse.getHeight() <= CornerRadius.m2686getYimpl($this$isEllipse.m2760getTopLeftCornerRadiuskKHJgLs()) * 2.0d) {
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    public static final boolean isCircle(RoundRect $this$isCircle) {
        Intrinsics.checkNotNullParameter($this$isCircle, "<this>");
        return (($this$isCircle.getWidth() > $this$isCircle.getHeight() ? 1 : ($this$isCircle.getWidth() == $this$isCircle.getHeight() ? 0 : -1)) == 0) && isEllipse($this$isCircle);
    }

    public static final float getMinDimension(RoundRect $this$minDimension) {
        Intrinsics.checkNotNullParameter($this$minDimension, "<this>");
        return Math.min(Math.abs($this$minDimension.getWidth()), Math.abs($this$minDimension.getHeight()));
    }

    public static final float getMaxDimension(RoundRect $this$maxDimension) {
        Intrinsics.checkNotNullParameter($this$maxDimension, "<this>");
        return Math.max(Math.abs($this$maxDimension.getWidth()), Math.abs($this$maxDimension.getHeight()));
    }

    public static final long getCenter(RoundRect $this$center) {
        Intrinsics.checkNotNullParameter($this$center, "<this>");
        return OffsetKt.Offset($this$center.getLeft() + ($this$center.getWidth() / 2.0f), $this$center.getTop() + ($this$center.getHeight() / 2.0f));
    }

    public static final boolean isSimple(RoundRect $this$isSimple) {
        Intrinsics.checkNotNullParameter($this$isSimple, "<this>");
        if (CornerRadius.m2685getXimpl($this$isSimple.m2760getTopLeftCornerRadiuskKHJgLs()) == CornerRadius.m2686getYimpl($this$isSimple.m2760getTopLeftCornerRadiuskKHJgLs())) {
            if (CornerRadius.m2685getXimpl($this$isSimple.m2760getTopLeftCornerRadiuskKHJgLs()) == CornerRadius.m2685getXimpl($this$isSimple.m2761getTopRightCornerRadiuskKHJgLs())) {
                if (CornerRadius.m2685getXimpl($this$isSimple.m2760getTopLeftCornerRadiuskKHJgLs()) == CornerRadius.m2686getYimpl($this$isSimple.m2761getTopRightCornerRadiuskKHJgLs())) {
                    if (CornerRadius.m2685getXimpl($this$isSimple.m2760getTopLeftCornerRadiuskKHJgLs()) == CornerRadius.m2685getXimpl($this$isSimple.m2759getBottomRightCornerRadiuskKHJgLs())) {
                        if (CornerRadius.m2685getXimpl($this$isSimple.m2760getTopLeftCornerRadiuskKHJgLs()) == CornerRadius.m2686getYimpl($this$isSimple.m2759getBottomRightCornerRadiuskKHJgLs())) {
                            if (CornerRadius.m2685getXimpl($this$isSimple.m2760getTopLeftCornerRadiuskKHJgLs()) == CornerRadius.m2685getXimpl($this$isSimple.m2758getBottomLeftCornerRadiuskKHJgLs())) {
                                if (CornerRadius.m2685getXimpl($this$isSimple.m2760getTopLeftCornerRadiuskKHJgLs()) == CornerRadius.m2686getYimpl($this$isSimple.m2758getBottomLeftCornerRadiuskKHJgLs())) {
                                    return true;
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    public static final RoundRect lerp(RoundRect start, RoundRect stop, float fraction) {
        Intrinsics.checkNotNullParameter(start, "start");
        Intrinsics.checkNotNullParameter(stop, "stop");
        return new RoundRect(MathHelpersKt.lerp(start.getLeft(), stop.getLeft(), fraction), MathHelpersKt.lerp(start.getTop(), stop.getTop(), fraction), MathHelpersKt.lerp(start.getRight(), stop.getRight(), fraction), MathHelpersKt.lerp(start.getBottom(), stop.getBottom(), fraction), CornerRadiusKt.m2696lerp3Ry4LBc(start.m2760getTopLeftCornerRadiuskKHJgLs(), stop.m2760getTopLeftCornerRadiuskKHJgLs(), fraction), CornerRadiusKt.m2696lerp3Ry4LBc(start.m2761getTopRightCornerRadiuskKHJgLs(), stop.m2761getTopRightCornerRadiuskKHJgLs(), fraction), CornerRadiusKt.m2696lerp3Ry4LBc(start.m2759getBottomRightCornerRadiuskKHJgLs(), stop.m2759getBottomRightCornerRadiuskKHJgLs(), fraction), CornerRadiusKt.m2696lerp3Ry4LBc(start.m2758getBottomLeftCornerRadiuskKHJgLs(), stop.m2758getBottomLeftCornerRadiuskKHJgLs(), fraction), null);
    }
}
