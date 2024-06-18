package androidx.compose.ui.text.style;

import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.text.SpanStyleKt;
import androidx.compose.ui.util.MathHelpersKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TextForegroundStyle.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u001a \u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0005H\u0000\u001a!\u0010\u0006\u001a\u00020\u0007*\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005H\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\t\u0010\n\u001a\u001a\u0010\u000b\u001a\u00020\u0005*\u00020\u00052\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\rH\u0002\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u000e"}, d2 = {"lerp", "Landroidx/compose/ui/text/style/TextForegroundStyle;", "start", "stop", "fraction", "", "modulate", "Landroidx/compose/ui/graphics/Color;", "alpha", "modulate-DxMtmZc", "(JF)J", "takeOrElse", "block", "Lkotlin/Function0;", "ui-text_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class TextDrawStyleKt {
    public static final TextForegroundStyle lerp(TextForegroundStyle start, TextForegroundStyle stop, float fraction) {
        Intrinsics.checkNotNullParameter(start, "start");
        Intrinsics.checkNotNullParameter(stop, "stop");
        if (!(start instanceof BrushStyle) && !(stop instanceof BrushStyle)) {
            return TextForegroundStyle.INSTANCE.m5109from8_81llA(ColorKt.m3000lerpjxsXWHM(start.mo4997getColor0d7_KjU(), stop.mo4997getColor0d7_KjU(), fraction));
        }
        if ((start instanceof BrushStyle) && (stop instanceof BrushStyle)) {
            return TextForegroundStyle.INSTANCE.from((Brush) SpanStyleKt.lerpDiscrete(((BrushStyle) start).getBrush(), ((BrushStyle) stop).getBrush(), fraction), MathHelpersKt.lerp(start.getAlpha(), stop.getAlpha(), fraction));
        }
        return (TextForegroundStyle) SpanStyleKt.lerpDiscrete(start, stop, fraction);
    }

    /* renamed from: modulate-DxMtmZc, reason: not valid java name */
    public static final long m5108modulateDxMtmZc(long $this$modulate_u2dDxMtmZc, float alpha) {
        long m2947copywmQWz5c;
        if (Float.isNaN(alpha) || alpha >= 1.0f) {
            return $this$modulate_u2dDxMtmZc;
        }
        m2947copywmQWz5c = Color.m2947copywmQWz5c($this$modulate_u2dDxMtmZc, (r12 & 1) != 0 ? Color.m2951getAlphaimpl($this$modulate_u2dDxMtmZc) : Color.m2951getAlphaimpl($this$modulate_u2dDxMtmZc) * alpha, (r12 & 2) != 0 ? Color.m2955getRedimpl($this$modulate_u2dDxMtmZc) : 0.0f, (r12 & 4) != 0 ? Color.m2954getGreenimpl($this$modulate_u2dDxMtmZc) : 0.0f, (r12 & 8) != 0 ? Color.m2952getBlueimpl($this$modulate_u2dDxMtmZc) : 0.0f);
        return m2947copywmQWz5c;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float takeOrElse(float $this$takeOrElse, Function0<Float> function0) {
        return Float.isNaN($this$takeOrElse) ? function0.invoke().floatValue() : $this$takeOrElse;
    }
}
