package androidx.compose.ui.graphics.drawscope;

import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.ClipOp;
import androidx.compose.ui.graphics.DegreesKt;
import androidx.compose.ui.graphics.Path;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DrawScope.kt */
@Metadata(d1 = {"\u0000D\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aH\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\b¢\u0006\u0002\b\tH\u0086\bø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b\n\u0010\u000b\u001ah\u0010\f\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u000e2\b\b\u0002\u0010\u0011\u001a\u00020\u000e2\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\b¢\u0006\u0002\b\tH\u0086\bø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b\u0012\u0010\u0013\u001a$\u0010\u0014\u001a\u00020\u0001*\u00020\u00022\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00010\bH\u0086\bø\u0001\u0000\u001a1\u0010\u0016\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u000e2\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\b¢\u0006\u0002\b\tH\u0086\bø\u0001\u0000\u001a=\u0010\u0016\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0017\u001a\u00020\u000e2\b\b\u0002\u0010\u0018\u001a\u00020\u000e2\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\b¢\u0006\u0002\b\tH\u0086\bø\u0001\u0000\u001aI\u0010\u0016\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u000e2\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\b¢\u0006\u0002\b\tH\u0086\bø\u0001\u0000\u001aH\u0010\u0019\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u000e2\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\b¢\u0006\u0002\b\tH\u0086\bø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b\u001d\u0010\u001e\u001aH\u0010\u001f\u001a\u00020\u0001*\u00020\u00022\u0006\u0010 \u001a\u00020\u000e2\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\b¢\u0006\u0002\b\tH\u0086\bø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b!\u0010\u001e\u001aH\u0010\"\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\"\u001a\u00020\u000e2\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\b¢\u0006\u0002\b\tH\u0086\bø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b#\u0010\u001e\u001aP\u0010\"\u001a\u00020\u0001*\u00020\u00022\u0006\u0010$\u001a\u00020\u000e2\u0006\u0010%\u001a\u00020\u000e2\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\b¢\u0006\u0002\b\tH\u0086\bø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b&\u0010'\u001a=\u0010(\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\b¢\u0006\u0002\b\tH\u0086\bø\u0001\u0000\u001aB\u0010)\u001a\u00020\u0001*\u00020\u00022\u0017\u0010*\u001a\u0013\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020\u00010\b¢\u0006\u0002\b\t2\u0017\u0010,\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\b¢\u0006\u0002\b\tH\u0086\bø\u0001\u0000\u0082\u0002\u0012\n\u0005\b\u009920\u0001\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006-"}, d2 = {"clipPath", "", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "path", "Landroidx/compose/ui/graphics/Path;", "clipOp", "Landroidx/compose/ui/graphics/ClipOp;", "block", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "clipPath-KD09W0M", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;Landroidx/compose/ui/graphics/Path;ILkotlin/jvm/functions/Function1;)V", "clipRect", "left", "", "top", "right", "bottom", "clipRect-rOu3jXo", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;FFFFILkotlin/jvm/functions/Function1;)V", "drawIntoCanvas", "Landroidx/compose/ui/graphics/Canvas;", "inset", "horizontal", "vertical", "rotate", "degrees", "pivot", "Landroidx/compose/ui/geometry/Offset;", "rotate-Rg1IO4c", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;FJLkotlin/jvm/functions/Function1;)V", "rotateRad", "radians", "rotateRad-Rg1IO4c", "scale", "scale-Rg1IO4c", "scaleX", "scaleY", "scale-Fgt4K4Q", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;FFJLkotlin/jvm/functions/Function1;)V", "translate", "withTransform", "transformBlock", "Landroidx/compose/ui/graphics/drawscope/DrawTransform;", "drawBlock", "ui-graphics_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class DrawScopeKt {
    public static final void inset(DrawScope $this$inset, float left, float top, float right, float bottom, Function1<? super DrawScope, Unit> block) {
        Intrinsics.checkNotNullParameter($this$inset, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        $this$inset.getDrawContext().getTransform().inset(left, top, right, bottom);
        block.invoke($this$inset);
        $this$inset.getDrawContext().getTransform().inset(-left, -top, -right, -bottom);
    }

    public static final void inset(DrawScope $this$inset, float inset, Function1<? super DrawScope, Unit> block) {
        Intrinsics.checkNotNullParameter($this$inset, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        $this$inset.getDrawContext().getTransform().inset(inset, inset, inset, inset);
        block.invoke($this$inset);
        $this$inset.getDrawContext().getTransform().inset(-inset, -inset, -inset, -inset);
    }

    public static /* synthetic */ void inset$default(DrawScope $this$inset_u24default, float horizontal, float vertical, Function1 block, int i, Object obj) {
        if ((i & 1) != 0) {
            horizontal = 0.0f;
        }
        if ((i & 2) != 0) {
            vertical = 0.0f;
        }
        Intrinsics.checkNotNullParameter($this$inset_u24default, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        $this$inset_u24default.getDrawContext().getTransform().inset(horizontal, vertical, horizontal, vertical);
        block.invoke($this$inset_u24default);
        $this$inset_u24default.getDrawContext().getTransform().inset(-horizontal, -vertical, -horizontal, -vertical);
    }

    public static final void inset(DrawScope $this$inset, float horizontal, float vertical, Function1<? super DrawScope, Unit> block) {
        Intrinsics.checkNotNullParameter($this$inset, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        $this$inset.getDrawContext().getTransform().inset(horizontal, vertical, horizontal, vertical);
        block.invoke($this$inset);
        $this$inset.getDrawContext().getTransform().inset(-horizontal, -vertical, -horizontal, -vertical);
    }

    public static /* synthetic */ void translate$default(DrawScope $this$translate_u24default, float left, float top, Function1 block, int i, Object obj) {
        if ((i & 1) != 0) {
            left = 0.0f;
        }
        if ((i & 2) != 0) {
            top = 0.0f;
        }
        Intrinsics.checkNotNullParameter($this$translate_u24default, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        $this$translate_u24default.getDrawContext().getTransform().translate(left, top);
        block.invoke($this$translate_u24default);
        $this$translate_u24default.getDrawContext().getTransform().translate(-left, -top);
    }

    public static final void translate(DrawScope $this$translate, float left, float top, Function1<? super DrawScope, Unit> block) {
        Intrinsics.checkNotNullParameter($this$translate, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        $this$translate.getDrawContext().getTransform().translate(left, top);
        block.invoke($this$translate);
        $this$translate.getDrawContext().getTransform().translate(-left, -top);
    }

    /* renamed from: rotate-Rg1IO4c$default, reason: not valid java name */
    public static /* synthetic */ void m3534rotateRg1IO4c$default(DrawScope rotate, float degrees, long pivot, Function1 block, int i, Object obj) {
        if ((i & 2) != 0) {
            pivot = rotate.mo3491getCenterF1C5BW0();
        }
        Intrinsics.checkNotNullParameter(rotate, "$this$rotate");
        Intrinsics.checkNotNullParameter(block, "block");
        DrawContext $this$withTransform_u24lambda_u246$iv = rotate.getDrawContext();
        long previousSize$iv = $this$withTransform_u24lambda_u246$iv.mo3417getSizeNHjbRc();
        $this$withTransform_u24lambda_u246$iv.getCanvas().save();
        DrawTransform $this$rotate_Rg1IO4c_u24lambda_u240 = $this$withTransform_u24lambda_u246$iv.getTransform();
        $this$rotate_Rg1IO4c_u24lambda_u240.mo3423rotateUv8p0NA(degrees, pivot);
        block.invoke(rotate);
        $this$withTransform_u24lambda_u246$iv.getCanvas().restore();
        $this$withTransform_u24lambda_u246$iv.mo3418setSizeuvyYCjk(previousSize$iv);
    }

    /* renamed from: rotate-Rg1IO4c, reason: not valid java name */
    public static final void m3533rotateRg1IO4c(DrawScope rotate, float degrees, long pivot, Function1<? super DrawScope, Unit> block) {
        Intrinsics.checkNotNullParameter(rotate, "$this$rotate");
        Intrinsics.checkNotNullParameter(block, "block");
        DrawContext $this$withTransform_u24lambda_u246$iv = rotate.getDrawContext();
        long previousSize$iv = $this$withTransform_u24lambda_u246$iv.mo3417getSizeNHjbRc();
        $this$withTransform_u24lambda_u246$iv.getCanvas().save();
        DrawTransform $this$rotate_Rg1IO4c_u24lambda_u240 = $this$withTransform_u24lambda_u246$iv.getTransform();
        $this$rotate_Rg1IO4c_u24lambda_u240.mo3423rotateUv8p0NA(degrees, pivot);
        block.invoke(rotate);
        $this$withTransform_u24lambda_u246$iv.getCanvas().restore();
        $this$withTransform_u24lambda_u246$iv.mo3418setSizeuvyYCjk(previousSize$iv);
    }

    /* renamed from: rotateRad-Rg1IO4c$default, reason: not valid java name */
    public static /* synthetic */ void m3536rotateRadRg1IO4c$default(DrawScope rotateRad, float radians, long pivot, Function1 block, int i, Object obj) {
        if ((i & 2) != 0) {
            pivot = rotateRad.mo3491getCenterF1C5BW0();
        }
        Intrinsics.checkNotNullParameter(rotateRad, "$this$rotateRad");
        Intrinsics.checkNotNullParameter(block, "block");
        DrawContext $this$withTransform_u24lambda_u246$iv = rotateRad.getDrawContext();
        long previousSize$iv = $this$withTransform_u24lambda_u246$iv.mo3417getSizeNHjbRc();
        $this$withTransform_u24lambda_u246$iv.getCanvas().save();
        DrawTransform $this$rotateRad_Rg1IO4c_u24lambda_u241 = $this$withTransform_u24lambda_u246$iv.getTransform();
        $this$rotateRad_Rg1IO4c_u24lambda_u241.mo3423rotateUv8p0NA(DegreesKt.degrees(radians), pivot);
        block.invoke(rotateRad);
        $this$withTransform_u24lambda_u246$iv.getCanvas().restore();
        $this$withTransform_u24lambda_u246$iv.mo3418setSizeuvyYCjk(previousSize$iv);
    }

    /* renamed from: rotateRad-Rg1IO4c, reason: not valid java name */
    public static final void m3535rotateRadRg1IO4c(DrawScope rotateRad, float radians, long pivot, Function1<? super DrawScope, Unit> block) {
        Intrinsics.checkNotNullParameter(rotateRad, "$this$rotateRad");
        Intrinsics.checkNotNullParameter(block, "block");
        DrawContext $this$withTransform_u24lambda_u246$iv = rotateRad.getDrawContext();
        long previousSize$iv = $this$withTransform_u24lambda_u246$iv.mo3417getSizeNHjbRc();
        $this$withTransform_u24lambda_u246$iv.getCanvas().save();
        DrawTransform $this$rotateRad_Rg1IO4c_u24lambda_u241 = $this$withTransform_u24lambda_u246$iv.getTransform();
        $this$rotateRad_Rg1IO4c_u24lambda_u241.mo3423rotateUv8p0NA(DegreesKt.degrees(radians), pivot);
        block.invoke(rotateRad);
        $this$withTransform_u24lambda_u246$iv.getCanvas().restore();
        $this$withTransform_u24lambda_u246$iv.mo3418setSizeuvyYCjk(previousSize$iv);
    }

    /* renamed from: scale-Fgt4K4Q$default, reason: not valid java name */
    public static /* synthetic */ void m3538scaleFgt4K4Q$default(DrawScope scale, float scaleX, float scaleY, long pivot, Function1 block, int i, Object obj) {
        if ((i & 4) != 0) {
            pivot = scale.mo3491getCenterF1C5BW0();
        }
        Intrinsics.checkNotNullParameter(scale, "$this$scale");
        Intrinsics.checkNotNullParameter(block, "block");
        DrawContext $this$withTransform_u24lambda_u246$iv = scale.getDrawContext();
        long previousSize$iv = $this$withTransform_u24lambda_u246$iv.mo3417getSizeNHjbRc();
        $this$withTransform_u24lambda_u246$iv.getCanvas().save();
        DrawTransform $this$scale_Fgt4K4Q_u24lambda_u242 = $this$withTransform_u24lambda_u246$iv.getTransform();
        $this$scale_Fgt4K4Q_u24lambda_u242.mo3424scale0AR0LA0(scaleX, scaleY, pivot);
        block.invoke(scale);
        $this$withTransform_u24lambda_u246$iv.getCanvas().restore();
        $this$withTransform_u24lambda_u246$iv.mo3418setSizeuvyYCjk(previousSize$iv);
    }

    /* renamed from: scale-Fgt4K4Q, reason: not valid java name */
    public static final void m3537scaleFgt4K4Q(DrawScope scale, float scaleX, float scaleY, long pivot, Function1<? super DrawScope, Unit> block) {
        Intrinsics.checkNotNullParameter(scale, "$this$scale");
        Intrinsics.checkNotNullParameter(block, "block");
        DrawContext $this$withTransform_u24lambda_u246$iv = scale.getDrawContext();
        long previousSize$iv = $this$withTransform_u24lambda_u246$iv.mo3417getSizeNHjbRc();
        $this$withTransform_u24lambda_u246$iv.getCanvas().save();
        DrawTransform $this$scale_Fgt4K4Q_u24lambda_u242 = $this$withTransform_u24lambda_u246$iv.getTransform();
        $this$scale_Fgt4K4Q_u24lambda_u242.mo3424scale0AR0LA0(scaleX, scaleY, pivot);
        block.invoke(scale);
        $this$withTransform_u24lambda_u246$iv.getCanvas().restore();
        $this$withTransform_u24lambda_u246$iv.mo3418setSizeuvyYCjk(previousSize$iv);
    }

    /* renamed from: scale-Rg1IO4c$default, reason: not valid java name */
    public static /* synthetic */ void m3540scaleRg1IO4c$default(DrawScope scale, float scale2, long pivot, Function1 block, int i, Object obj) {
        if ((i & 2) != 0) {
            pivot = scale.mo3491getCenterF1C5BW0();
        }
        Intrinsics.checkNotNullParameter(scale, "$this$scale");
        Intrinsics.checkNotNullParameter(block, "block");
        DrawContext $this$withTransform_u24lambda_u246$iv = scale.getDrawContext();
        long previousSize$iv = $this$withTransform_u24lambda_u246$iv.mo3417getSizeNHjbRc();
        $this$withTransform_u24lambda_u246$iv.getCanvas().save();
        DrawTransform $this$scale_Rg1IO4c_u24lambda_u243 = $this$withTransform_u24lambda_u246$iv.getTransform();
        $this$scale_Rg1IO4c_u24lambda_u243.mo3424scale0AR0LA0(scale2, scale2, pivot);
        block.invoke(scale);
        $this$withTransform_u24lambda_u246$iv.getCanvas().restore();
        $this$withTransform_u24lambda_u246$iv.mo3418setSizeuvyYCjk(previousSize$iv);
    }

    /* renamed from: scale-Rg1IO4c, reason: not valid java name */
    public static final void m3539scaleRg1IO4c(DrawScope scale, float scale2, long pivot, Function1<? super DrawScope, Unit> block) {
        Intrinsics.checkNotNullParameter(scale, "$this$scale");
        Intrinsics.checkNotNullParameter(block, "block");
        DrawContext $this$withTransform_u24lambda_u246$iv = scale.getDrawContext();
        long previousSize$iv = $this$withTransform_u24lambda_u246$iv.mo3417getSizeNHjbRc();
        $this$withTransform_u24lambda_u246$iv.getCanvas().save();
        DrawTransform $this$scale_Rg1IO4c_u24lambda_u243 = $this$withTransform_u24lambda_u246$iv.getTransform();
        $this$scale_Rg1IO4c_u24lambda_u243.mo3424scale0AR0LA0(scale2, scale2, pivot);
        block.invoke(scale);
        $this$withTransform_u24lambda_u246$iv.getCanvas().restore();
        $this$withTransform_u24lambda_u246$iv.mo3418setSizeuvyYCjk(previousSize$iv);
    }

    /* renamed from: clipRect-rOu3jXo$default, reason: not valid java name */
    public static /* synthetic */ void m3532clipRectrOu3jXo$default(DrawScope clipRect, float left, float top, float right, float bottom, int clipOp, Function1 block, int i, Object obj) {
        float left2 = (i & 1) != 0 ? 0.0f : left;
        float top2 = (i & 2) != 0 ? 0.0f : top;
        float right2 = (i & 4) != 0 ? Size.m2779getWidthimpl(clipRect.mo3492getSizeNHjbRc()) : right;
        float bottom2 = (i & 8) != 0 ? Size.m2776getHeightimpl(clipRect.mo3492getSizeNHjbRc()) : bottom;
        int clipOp2 = (i & 16) != 0 ? ClipOp.INSTANCE.m2938getIntersectrtfAjoo() : clipOp;
        Intrinsics.checkNotNullParameter(clipRect, "$this$clipRect");
        Intrinsics.checkNotNullParameter(block, "block");
        DrawContext $this$withTransform_u24lambda_u246$iv = clipRect.getDrawContext();
        long previousSize$iv = $this$withTransform_u24lambda_u246$iv.mo3417getSizeNHjbRc();
        $this$withTransform_u24lambda_u246$iv.getCanvas().save();
        DrawTransform $this$clipRect_rOu3jXo_u24lambda_u244 = $this$withTransform_u24lambda_u246$iv.getTransform();
        $this$clipRect_rOu3jXo_u24lambda_u244.mo3420clipRectN_I0leg(left2, top2, right2, bottom2, clipOp2);
        block.invoke(clipRect);
        $this$withTransform_u24lambda_u246$iv.getCanvas().restore();
        $this$withTransform_u24lambda_u246$iv.mo3418setSizeuvyYCjk(previousSize$iv);
    }

    /* renamed from: clipRect-rOu3jXo, reason: not valid java name */
    public static final void m3531clipRectrOu3jXo(DrawScope clipRect, float left, float top, float right, float bottom, int clipOp, Function1<? super DrawScope, Unit> block) {
        Intrinsics.checkNotNullParameter(clipRect, "$this$clipRect");
        Intrinsics.checkNotNullParameter(block, "block");
        DrawContext $this$withTransform_u24lambda_u246$iv = clipRect.getDrawContext();
        long previousSize$iv = $this$withTransform_u24lambda_u246$iv.mo3417getSizeNHjbRc();
        $this$withTransform_u24lambda_u246$iv.getCanvas().save();
        DrawTransform $this$clipRect_rOu3jXo_u24lambda_u244 = $this$withTransform_u24lambda_u246$iv.getTransform();
        $this$clipRect_rOu3jXo_u24lambda_u244.mo3420clipRectN_I0leg(left, top, right, bottom, clipOp);
        block.invoke(clipRect);
        $this$withTransform_u24lambda_u246$iv.getCanvas().restore();
        $this$withTransform_u24lambda_u246$iv.mo3418setSizeuvyYCjk(previousSize$iv);
    }

    /* renamed from: clipPath-KD09W0M$default, reason: not valid java name */
    public static /* synthetic */ void m3530clipPathKD09W0M$default(DrawScope clipPath, Path path, int clipOp, Function1 block, int i, Object obj) {
        if ((i & 2) != 0) {
            clipOp = ClipOp.INSTANCE.m2938getIntersectrtfAjoo();
        }
        Intrinsics.checkNotNullParameter(clipPath, "$this$clipPath");
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(block, "block");
        DrawContext $this$withTransform_u24lambda_u246$iv = clipPath.getDrawContext();
        long previousSize$iv = $this$withTransform_u24lambda_u246$iv.mo3417getSizeNHjbRc();
        $this$withTransform_u24lambda_u246$iv.getCanvas().save();
        DrawTransform $this$clipPath_KD09W0M_u24lambda_u245 = $this$withTransform_u24lambda_u246$iv.getTransform();
        $this$clipPath_KD09W0M_u24lambda_u245.mo3419clipPathmtrdDE(path, clipOp);
        block.invoke(clipPath);
        $this$withTransform_u24lambda_u246$iv.getCanvas().restore();
        $this$withTransform_u24lambda_u246$iv.mo3418setSizeuvyYCjk(previousSize$iv);
    }

    /* renamed from: clipPath-KD09W0M, reason: not valid java name */
    public static final void m3529clipPathKD09W0M(DrawScope clipPath, Path path, int clipOp, Function1<? super DrawScope, Unit> block) {
        Intrinsics.checkNotNullParameter(clipPath, "$this$clipPath");
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(block, "block");
        DrawContext $this$withTransform_u24lambda_u246$iv = clipPath.getDrawContext();
        long previousSize$iv = $this$withTransform_u24lambda_u246$iv.mo3417getSizeNHjbRc();
        $this$withTransform_u24lambda_u246$iv.getCanvas().save();
        DrawTransform $this$clipPath_KD09W0M_u24lambda_u245 = $this$withTransform_u24lambda_u246$iv.getTransform();
        $this$clipPath_KD09W0M_u24lambda_u245.mo3419clipPathmtrdDE(path, clipOp);
        block.invoke(clipPath);
        $this$withTransform_u24lambda_u246$iv.getCanvas().restore();
        $this$withTransform_u24lambda_u246$iv.mo3418setSizeuvyYCjk(previousSize$iv);
    }

    public static final void drawIntoCanvas(DrawScope $this$drawIntoCanvas, Function1<? super Canvas, Unit> block) {
        Intrinsics.checkNotNullParameter($this$drawIntoCanvas, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        block.invoke($this$drawIntoCanvas.getDrawContext().getCanvas());
    }

    public static final void withTransform(DrawScope $this$withTransform, Function1<? super DrawTransform, Unit> transformBlock, Function1<? super DrawScope, Unit> drawBlock) {
        Intrinsics.checkNotNullParameter($this$withTransform, "<this>");
        Intrinsics.checkNotNullParameter(transformBlock, "transformBlock");
        Intrinsics.checkNotNullParameter(drawBlock, "drawBlock");
        DrawContext $this$withTransform_u24lambda_u246 = $this$withTransform.getDrawContext();
        long previousSize = $this$withTransform_u24lambda_u246.mo3417getSizeNHjbRc();
        $this$withTransform_u24lambda_u246.getCanvas().save();
        transformBlock.invoke($this$withTransform_u24lambda_u246.getTransform());
        drawBlock.invoke($this$withTransform);
        $this$withTransform_u24lambda_u246.getCanvas().restore();
        $this$withTransform_u24lambda_u246.mo3418setSizeuvyYCjk(previousSize);
    }
}
