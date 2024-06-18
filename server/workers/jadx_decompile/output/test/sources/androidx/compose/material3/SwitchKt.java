package androidx.compose.material3;

import androidx.compose.animation.core.TweenSpec;
import androidx.compose.material3.tokens.SwitchTokens;
import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.unit.Dp;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;

/* compiled from: Switch.kt */
@Metadata(d1 = {"\u0000^\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u001aj\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0014\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00152\u0015\b\u0002\u0010\u0016\u001a\u000f\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u0017¢\u0006\u0002\b\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u00112\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u001dH\u0007¢\u0006\u0002\u0010\u001e\u001a|\u0010\u001f\u001a\u00020\u000f*\u00020 2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u001b2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00020\"2\u0013\u0010\u0016\u001a\u000f\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u0017¢\u0006\u0002\b\u00182\u0006\u0010\u001c\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u00042\u0006\u0010'\u001a\u00020\u00042\u0006\u0010(\u001a\u00020\u0004H\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b)\u0010*\"\u0014\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0013\u0010\u0003\u001a\u00020\u0004X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0005\"\u0013\u0010\u0006\u001a\u00020\u0004X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0005\"\u0019\u0010\u0007\u001a\u00020\u0004X\u0080\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u0005\u001a\u0004\b\b\u0010\t\"\u0013\u0010\n\u001a\u00020\u0004X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0005\"\u0013\u0010\u000b\u001a\u00020\u0004X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0005\"\u0019\u0010\f\u001a\u00020\u0004X\u0080\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u0005\u001a\u0004\b\r\u0010\t\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006+"}, d2 = {"AnimationSpec", "Landroidx/compose/animation/core/TweenSpec;", "", "SwitchHeight", "Landroidx/compose/ui/unit/Dp;", "F", "SwitchWidth", "ThumbDiameter", "getThumbDiameter", "()F", "ThumbPadding", "ThumbPathLength", "UncheckedThumbDiameter", "getUncheckedThumbDiameter", "Switch", "", "checked", "", "onCheckedChange", "Lkotlin/Function1;", "modifier", "Landroidx/compose/ui/Modifier;", "thumbContent", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "enabled", "colors", "Landroidx/compose/material3/SwitchColors;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "(ZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/material3/SwitchColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", "SwitchImpl", "Landroidx/compose/foundation/layout/BoxScope;", "thumbValue", "Landroidx/compose/runtime/State;", "Landroidx/compose/foundation/interaction/InteractionSource;", "thumbShape", "Landroidx/compose/ui/graphics/Shape;", "uncheckedThumbDiameter", "minBound", "maxBound", "SwitchImpl-0DmnUew", "(Landroidx/compose/foundation/layout/BoxScope;ZZLandroidx/compose/material3/SwitchColors;Landroidx/compose/runtime/State;Lkotlin/jvm/functions/Function2;Landroidx/compose/foundation/interaction/InteractionSource;Landroidx/compose/ui/graphics/Shape;FFFLandroidx/compose/runtime/Composer;II)V", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class SwitchKt {
    private static final TweenSpec<Float> AnimationSpec;
    private static final float ThumbPadding;
    private static final float ThumbPathLength;
    private static final float ThumbDiameter = SwitchTokens.INSTANCE.m2462getSelectedHandleWidthD9Ej5fM();
    private static final float UncheckedThumbDiameter = SwitchTokens.INSTANCE.m2469getUnselectedHandleWidthD9Ej5fM();
    private static final float SwitchWidth = SwitchTokens.INSTANCE.m2467getTrackWidthD9Ej5fM();
    private static final float SwitchHeight = SwitchTokens.INSTANCE.m2465getTrackHeightD9Ej5fM();

    /* JADX WARN: Removed duplicated region for block: B:59:0x02b8  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0307  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0352  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x038f  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0466  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0472  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x056b  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0476  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0398  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x037f  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0324  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x02c9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void Switch(final boolean r53, final kotlin.jvm.functions.Function1<? super java.lang.Boolean, kotlin.Unit> r54, androidx.compose.ui.Modifier r55, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r56, boolean r57, androidx.compose.material3.SwitchColors r58, androidx.compose.foundation.interaction.MutableInteractionSource r59, androidx.compose.runtime.Composer r60, final int r61, final int r62) {
        /*
            Method dump skipped, instructions count: 1430
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.SwitchKt.Switch(boolean, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, kotlin.jvm.functions.Function2, boolean, androidx.compose.material3.SwitchColors, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0513  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x051f  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x05b0  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0620  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x05e3  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0523  */
    /* renamed from: SwitchImpl-0DmnUew, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void m1816SwitchImpl0DmnUew(final androidx.compose.foundation.layout.BoxScope r64, final boolean r65, final boolean r66, final androidx.compose.material3.SwitchColors r67, final androidx.compose.runtime.State<java.lang.Float> r68, final kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r69, final androidx.compose.foundation.interaction.InteractionSource r70, final androidx.compose.ui.graphics.Shape r71, final float r72, final float r73, final float r74, androidx.compose.runtime.Composer r75, final int r76, final int r77) {
        /*
            Method dump skipped, instructions count: 1631
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.SwitchKt.m1816SwitchImpl0DmnUew(androidx.compose.foundation.layout.BoxScope, boolean, boolean, androidx.compose.material3.SwitchColors, androidx.compose.runtime.State, kotlin.jvm.functions.Function2, androidx.compose.foundation.interaction.InteractionSource, androidx.compose.ui.graphics.Shape, float, float, float, androidx.compose.runtime.Composer, int, int):void");
    }

    private static final long SwitchImpl_0DmnUew$lambda$6(State<Color> state) {
        Object thisObj$iv = state.getValue();
        return ((Color) thisObj$iv).m2959unboximpl();
    }

    private static final boolean SwitchImpl_0DmnUew$lambda$7(State<Boolean> state) {
        Object thisObj$iv = state.getValue();
        return ((Boolean) thisObj$iv).booleanValue();
    }

    private static final long SwitchImpl_0DmnUew$lambda$13$lambda$10(State<Color> state) {
        Object thisObj$iv = state.getValue();
        return ((Color) thisObj$iv).m2959unboximpl();
    }

    static {
        float arg0$iv = SwitchHeight;
        float other$iv = ThumbDiameter;
        ThumbPadding = Dp.m5218constructorimpl(Dp.m5218constructorimpl(arg0$iv - other$iv) / 2);
        float arg0$iv2 = SwitchWidth;
        float other$iv2 = ThumbDiameter;
        float arg0$iv3 = Dp.m5218constructorimpl(arg0$iv2 - other$iv2);
        float other$iv3 = ThumbPadding;
        ThumbPathLength = Dp.m5218constructorimpl(arg0$iv3 - other$iv3);
        AnimationSpec = new TweenSpec<>(100, 0, null, 6, null);
    }

    public static final float getThumbDiameter() {
        return ThumbDiameter;
    }

    public static final float getUncheckedThumbDiameter() {
        return UncheckedThumbDiameter;
    }
}
