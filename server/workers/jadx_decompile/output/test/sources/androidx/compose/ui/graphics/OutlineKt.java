package androidx.compose.ui.graphics;

import androidx.autofill.HintConstants;
import androidx.compose.ui.geometry.CornerRadius;
import androidx.compose.ui.geometry.CornerRadiusKt;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RoundRect;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.Outline;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Outline.kt */
@Metadata(d1 = {"\u0000|\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004\u001a\u001a\u0010\u0005\u001a\u00020\u0001*\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b\u001aQ\u0010\u0005\u001a\u00020\u0001*\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u0013ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0014\u0010\u0015\u001aQ\u0010\u0005\u001a\u00020\u0001*\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u0013ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0018\u0010\u0019\u001a\u009f\u0001\u0010\u001a\u001a\u00020\u0001*\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00042,\u0010\u001b\u001a(\u0012\u0004\u0012\u00020\t\u0012\u0013\u0012\u00110\u001d¢\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b( \u0012\u0004\u0012\u00020\u00010\u001c¢\u0006\u0002\b!2,\u0010\"\u001a(\u0012\u0004\u0012\u00020\t\u0012\u0013\u0012\u00110#¢\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b($\u0012\u0004\u0012\u00020\u00010\u001c¢\u0006\u0002\b!2,\u0010%\u001a(\u0012\u0004\u0012\u00020\t\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b(&\u0012\u0004\u0012\u00020\u00010\u001c¢\u0006\u0002\b!H\u0082\b\u001a\f\u0010'\u001a\u00020(*\u00020#H\u0002\u001a\u0014\u0010)\u001a\u00020**\u00020\u001dH\u0002ø\u0001\u0001¢\u0006\u0002\u0010+\u001a\u0014\u0010)\u001a\u00020**\u00020#H\u0002ø\u0001\u0001¢\u0006\u0002\u0010,\u001a\u0014\u0010-\u001a\u00020.*\u00020\u001dH\u0002ø\u0001\u0001¢\u0006\u0002\u0010+\u001a\u0014\u0010-\u001a\u00020.*\u00020#H\u0002ø\u0001\u0001¢\u0006\u0002\u0010,\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006/"}, d2 = {"addOutline", "", "Landroidx/compose/ui/graphics/Path;", "outline", "Landroidx/compose/ui/graphics/Outline;", "drawOutline", "Landroidx/compose/ui/graphics/Canvas;", "paint", "Landroidx/compose/ui/graphics/Paint;", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "brush", "Landroidx/compose/ui/graphics/Brush;", "alpha", "", "style", "Landroidx/compose/ui/graphics/drawscope/DrawStyle;", "colorFilter", "Landroidx/compose/ui/graphics/ColorFilter;", "blendMode", "Landroidx/compose/ui/graphics/BlendMode;", "drawOutline-hn5TExg", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;Landroidx/compose/ui/graphics/Outline;Landroidx/compose/ui/graphics/Brush;FLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "color", "Landroidx/compose/ui/graphics/Color;", "drawOutline-wDX37Ww", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;Landroidx/compose/ui/graphics/Outline;JFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawOutlineHelper", "drawRectBlock", "Lkotlin/Function2;", "Landroidx/compose/ui/geometry/Rect;", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, "rect", "Lkotlin/ExtensionFunctionType;", "drawRoundedRectBlock", "Landroidx/compose/ui/geometry/RoundRect;", "rrect", "drawPathBlock", "path", "hasSameCornerRadius", "", "size", "Landroidx/compose/ui/geometry/Size;", "(Landroidx/compose/ui/geometry/Rect;)J", "(Landroidx/compose/ui/geometry/RoundRect;)J", "topLeft", "Landroidx/compose/ui/geometry/Offset;", "ui-graphics_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class OutlineKt {
    public static final void addOutline(Path $this$addOutline, Outline outline) {
        Intrinsics.checkNotNullParameter($this$addOutline, "<this>");
        Intrinsics.checkNotNullParameter(outline, "outline");
        if (!(outline instanceof Outline.Rectangle)) {
            if (!(outline instanceof Outline.Rounded)) {
                if (!(outline instanceof Outline.Generic)) {
                    throw new NoWhenBranchMatchedException();
                }
                Path.m3213addPathUv8p0NA$default($this$addOutline, ((Outline.Generic) outline).getPath(), 0L, 2, null);
                return;
            }
            $this$addOutline.addRoundRect(((Outline.Rounded) outline).getRoundRect());
            return;
        }
        $this$addOutline.addRect(((Outline.Rectangle) outline).getRect());
    }

    /* renamed from: drawOutline-wDX37Ww */
    public static final void m3201drawOutlinewDX37Ww(DrawScope drawOutline, Outline outline, long color, float alpha, DrawStyle style, ColorFilter colorFilter, int blendMode) {
        Intrinsics.checkNotNullParameter(drawOutline, "$this$drawOutline");
        Intrinsics.checkNotNullParameter(outline, "outline");
        Intrinsics.checkNotNullParameter(style, "style");
        if (outline instanceof Outline.Rectangle) {
            Rect rect = ((Outline.Rectangle) outline).getRect();
            drawOutline.mo3409drawRectnJ9OG0(color, topLeft(rect), size(rect), alpha, style, colorFilter, blendMode);
            return;
        }
        if (outline instanceof Outline.Rounded) {
            Path path$iv = ((Outline.Rounded) outline).getRoundRectPath();
            if (path$iv != null) {
                drawOutline.mo3405drawPathLG529CI(path$iv, color, alpha, style, colorFilter, blendMode);
                return;
            }
            RoundRect rrect = ((Outline.Rounded) outline).getRoundRect();
            float radius = CornerRadius.m2685getXimpl(rrect.m2758getBottomLeftCornerRadiuskKHJgLs());
            drawOutline.mo3411drawRoundRectuAw5IA(color, topLeft(rrect), size(rrect), CornerRadiusKt.CornerRadius$default(radius, 0.0f, 2, null), style, alpha, colorFilter, blendMode);
            return;
        }
        if (outline instanceof Outline.Generic) {
            Path path = ((Outline.Generic) outline).getPath();
            drawOutline.mo3405drawPathLG529CI(path, color, alpha, style, colorFilter, blendMode);
            return;
        }
        throw new NoWhenBranchMatchedException();
    }

    /* renamed from: drawOutline-hn5TExg */
    public static final void m3199drawOutlinehn5TExg(DrawScope drawOutline, Outline outline, Brush brush, float alpha, DrawStyle style, ColorFilter colorFilter, int blendMode) {
        Intrinsics.checkNotNullParameter(drawOutline, "$this$drawOutline");
        Intrinsics.checkNotNullParameter(outline, "outline");
        Intrinsics.checkNotNullParameter(brush, "brush");
        Intrinsics.checkNotNullParameter(style, "style");
        if (outline instanceof Outline.Rectangle) {
            Rect rect = ((Outline.Rectangle) outline).getRect();
            drawOutline.mo3408drawRectAsUm42w(brush, topLeft(rect), size(rect), alpha, style, colorFilter, blendMode);
            return;
        }
        if (outline instanceof Outline.Rounded) {
            Path path$iv = ((Outline.Rounded) outline).getRoundRectPath();
            if (path$iv != null) {
                drawOutline.mo3404drawPathGBMwjPU(path$iv, brush, alpha, style, colorFilter, blendMode);
                return;
            }
            RoundRect rrect = ((Outline.Rounded) outline).getRoundRect();
            float radius = CornerRadius.m2685getXimpl(rrect.m2758getBottomLeftCornerRadiuskKHJgLs());
            drawOutline.mo3410drawRoundRectZuiqVtQ(brush, topLeft(rrect), size(rrect), CornerRadiusKt.CornerRadius$default(radius, 0.0f, 2, null), alpha, style, colorFilter, blendMode);
            return;
        }
        if (outline instanceof Outline.Generic) {
            Path path = ((Outline.Generic) outline).getPath();
            drawOutline.mo3404drawPathGBMwjPU(path, brush, alpha, style, colorFilter, blendMode);
            return;
        }
        throw new NoWhenBranchMatchedException();
    }

    private static final long topLeft(Rect $this$topLeft) {
        return OffsetKt.Offset($this$topLeft.getLeft(), $this$topLeft.getTop());
    }

    private static final long size(Rect $this$size) {
        return SizeKt.Size($this$size.getWidth(), $this$size.getHeight());
    }

    private static final long topLeft(RoundRect $this$topLeft) {
        return OffsetKt.Offset($this$topLeft.getLeft(), $this$topLeft.getTop());
    }

    private static final long size(RoundRect $this$size) {
        return SizeKt.Size($this$size.getWidth(), $this$size.getHeight());
    }

    private static final void drawOutlineHelper(DrawScope $this$drawOutlineHelper, Outline outline, Function2<? super DrawScope, ? super Rect, Unit> function2, Function2<? super DrawScope, ? super RoundRect, Unit> function22, Function2<? super DrawScope, ? super Path, Unit> function23) {
        if (!(outline instanceof Outline.Rectangle)) {
            if (outline instanceof Outline.Rounded) {
                Path path = ((Outline.Rounded) outline).getRoundRectPath();
                if (path != null) {
                    function23.invoke($this$drawOutlineHelper, path);
                    return;
                } else {
                    function22.invoke($this$drawOutlineHelper, ((Outline.Rounded) outline).getRoundRect());
                    return;
                }
            }
            if (!(outline instanceof Outline.Generic)) {
                throw new NoWhenBranchMatchedException();
            }
            function23.invoke($this$drawOutlineHelper, ((Outline.Generic) outline).getPath());
            return;
        }
        function2.invoke($this$drawOutlineHelper, ((Outline.Rectangle) outline).getRect());
    }

    public static final void drawOutline(Canvas $this$drawOutline, Outline outline, Paint paint) {
        Intrinsics.checkNotNullParameter($this$drawOutline, "<this>");
        Intrinsics.checkNotNullParameter(outline, "outline");
        Intrinsics.checkNotNullParameter(paint, "paint");
        if (!(outline instanceof Outline.Rectangle)) {
            if (outline instanceof Outline.Rounded) {
                Path path = ((Outline.Rounded) outline).getRoundRectPath();
                if (path != null) {
                    $this$drawOutline.drawPath(path, paint);
                    return;
                } else {
                    $this$drawOutline.drawRoundRect(((Outline.Rounded) outline).getRoundRect().getLeft(), ((Outline.Rounded) outline).getRoundRect().getTop(), ((Outline.Rounded) outline).getRoundRect().getRight(), ((Outline.Rounded) outline).getRoundRect().getBottom(), CornerRadius.m2685getXimpl(((Outline.Rounded) outline).getRoundRect().m2758getBottomLeftCornerRadiuskKHJgLs()), CornerRadius.m2686getYimpl(((Outline.Rounded) outline).getRoundRect().m2758getBottomLeftCornerRadiuskKHJgLs()), paint);
                    return;
                }
            }
            if (!(outline instanceof Outline.Generic)) {
                throw new NoWhenBranchMatchedException();
            }
            $this$drawOutline.drawPath(((Outline.Generic) outline).getPath(), paint);
            return;
        }
        $this$drawOutline.drawRect(((Outline.Rectangle) outline).getRect(), paint);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00a2 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0067  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final boolean hasSameCornerRadius(androidx.compose.ui.geometry.RoundRect r6) {
        /*
            long r0 = r6.m2758getBottomLeftCornerRadiuskKHJgLs()
            float r0 = androidx.compose.ui.geometry.CornerRadius.m2685getXimpl(r0)
            long r1 = r6.m2759getBottomRightCornerRadiuskKHJgLs()
            float r1 = androidx.compose.ui.geometry.CornerRadius.m2685getXimpl(r1)
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            r1 = 1
            r2 = 0
            if (r0 != 0) goto L18
            r0 = r1
            goto L19
        L18:
            r0 = r2
        L19:
            if (r0 == 0) goto L4f
            long r3 = r6.m2759getBottomRightCornerRadiuskKHJgLs()
            float r0 = androidx.compose.ui.geometry.CornerRadius.m2685getXimpl(r3)
            long r3 = r6.m2761getTopRightCornerRadiuskKHJgLs()
            float r3 = androidx.compose.ui.geometry.CornerRadius.m2685getXimpl(r3)
            int r0 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r0 != 0) goto L31
            r0 = r1
            goto L32
        L31:
            r0 = r2
        L32:
            if (r0 == 0) goto L4f
            long r3 = r6.m2761getTopRightCornerRadiuskKHJgLs()
            float r0 = androidx.compose.ui.geometry.CornerRadius.m2685getXimpl(r3)
            long r3 = r6.m2760getTopLeftCornerRadiuskKHJgLs()
            float r3 = androidx.compose.ui.geometry.CornerRadius.m2685getXimpl(r3)
            int r0 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r0 != 0) goto L4a
            r0 = r1
            goto L4b
        L4a:
            r0 = r2
        L4b:
            if (r0 == 0) goto L4f
            r0 = r1
            goto L50
        L4f:
            r0 = r2
        L50:
            long r3 = r6.m2758getBottomLeftCornerRadiuskKHJgLs()
            float r3 = androidx.compose.ui.geometry.CornerRadius.m2686getYimpl(r3)
            long r4 = r6.m2759getBottomRightCornerRadiuskKHJgLs()
            float r4 = androidx.compose.ui.geometry.CornerRadius.m2686getYimpl(r4)
            int r3 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
            if (r3 != 0) goto L67
            r3 = r1
            goto L68
        L67:
            r3 = r2
        L68:
            if (r3 == 0) goto L9e
            long r3 = r6.m2759getBottomRightCornerRadiuskKHJgLs()
            float r3 = androidx.compose.ui.geometry.CornerRadius.m2686getYimpl(r3)
            long r4 = r6.m2761getTopRightCornerRadiuskKHJgLs()
            float r4 = androidx.compose.ui.geometry.CornerRadius.m2686getYimpl(r4)
            int r3 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
            if (r3 != 0) goto L80
            r3 = r1
            goto L81
        L80:
            r3 = r2
        L81:
            if (r3 == 0) goto L9e
            long r3 = r6.m2761getTopRightCornerRadiuskKHJgLs()
            float r3 = androidx.compose.ui.geometry.CornerRadius.m2686getYimpl(r3)
            long r4 = r6.m2760getTopLeftCornerRadiuskKHJgLs()
            float r4 = androidx.compose.ui.geometry.CornerRadius.m2686getYimpl(r4)
            int r3 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
            if (r3 != 0) goto L99
            r3 = r1
            goto L9a
        L99:
            r3 = r2
        L9a:
            if (r3 == 0) goto L9e
            r3 = r1
            goto L9f
        L9e:
            r3 = r2
        L9f:
            if (r0 == 0) goto La5
            if (r3 == 0) goto La5
            goto La6
        La5:
            r1 = r2
        La6:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.graphics.OutlineKt.hasSameCornerRadius(androidx.compose.ui.geometry.RoundRect):boolean");
    }
}
