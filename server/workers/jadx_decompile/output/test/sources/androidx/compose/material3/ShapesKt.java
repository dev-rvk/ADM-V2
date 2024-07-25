package androidx.compose.material3;

import androidx.compose.foundation.shape.CornerBasedShape;
import androidx.compose.foundation.shape.CornerSizeKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.tokens.ShapeKeyTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.ui.graphics.RectangleShapeKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.unit.Dp;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Shapes.kt */
@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\f\u0010\u0005\u001a\u00020\u0006*\u00020\u0006H\u0000\u001a\f\u0010\u0007\u001a\u00020\u0006*\u00020\u0006H\u0000\u001a\u0014\u0010\b\u001a\u00020\t*\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bH\u0000\u001a\f\u0010\f\u001a\u00020\u0006*\u00020\u0006H\u0000\u001a\u0011\u0010\r\u001a\u00020\t*\u00020\u000bH\u0001¢\u0006\u0002\u0010\u000e\u001a\f\u0010\u000f\u001a\u00020\u0006*\u00020\u0006H\u0000\"\u001a\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0010"}, d2 = {"LocalShapes", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "Landroidx/compose/material3/Shapes;", "getLocalShapes", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "bottom", "Landroidx/compose/foundation/shape/CornerBasedShape;", "end", "fromToken", "Landroidx/compose/ui/graphics/Shape;", "value", "Landroidx/compose/material3/tokens/ShapeKeyTokens;", "start", "toShape", "(Landroidx/compose/material3/tokens/ShapeKeyTokens;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/Shape;", "top", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class ShapesKt {
    private static final ProvidableCompositionLocal<Shapes> LocalShapes = CompositionLocalKt.staticCompositionLocalOf(new Function0<Shapes>() { // from class: androidx.compose.material3.ShapesKt$LocalShapes$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final Shapes invoke() {
            return new Shapes(null, null, null, null, null, 31, null);
        }
    });

    /* compiled from: Shapes.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ShapeKeyTokens.values().length];
            try {
                iArr[ShapeKeyTokens.CornerExtraLarge.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[ShapeKeyTokens.CornerExtraLargeTop.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[ShapeKeyTokens.CornerExtraSmall.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[ShapeKeyTokens.CornerExtraSmallTop.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                iArr[ShapeKeyTokens.CornerFull.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                iArr[ShapeKeyTokens.CornerLarge.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                iArr[ShapeKeyTokens.CornerLargeEnd.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            try {
                iArr[ShapeKeyTokens.CornerLargeTop.ordinal()] = 8;
            } catch (NoSuchFieldError e8) {
            }
            try {
                iArr[ShapeKeyTokens.CornerMedium.ordinal()] = 9;
            } catch (NoSuchFieldError e9) {
            }
            try {
                iArr[ShapeKeyTokens.CornerNone.ordinal()] = 10;
            } catch (NoSuchFieldError e10) {
            }
            try {
                iArr[ShapeKeyTokens.CornerSmall.ordinal()] = 11;
            } catch (NoSuchFieldError e11) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final CornerBasedShape top(CornerBasedShape $this$top) {
        Intrinsics.checkNotNullParameter($this$top, "<this>");
        return CornerBasedShape.copy$default($this$top, null, null, CornerSizeKt.m729CornerSize0680j_4(Dp.m5218constructorimpl((float) 0.0d)), CornerSizeKt.m729CornerSize0680j_4(Dp.m5218constructorimpl((float) 0.0d)), 3, null);
    }

    public static final CornerBasedShape bottom(CornerBasedShape $this$bottom) {
        Intrinsics.checkNotNullParameter($this$bottom, "<this>");
        return CornerBasedShape.copy$default($this$bottom, CornerSizeKt.m729CornerSize0680j_4(Dp.m5218constructorimpl((float) 0.0d)), CornerSizeKt.m729CornerSize0680j_4(Dp.m5218constructorimpl((float) 0.0d)), null, null, 12, null);
    }

    public static final CornerBasedShape start(CornerBasedShape $this$start) {
        Intrinsics.checkNotNullParameter($this$start, "<this>");
        return CornerBasedShape.copy$default($this$start, null, CornerSizeKt.m729CornerSize0680j_4(Dp.m5218constructorimpl((float) 0.0d)), CornerSizeKt.m729CornerSize0680j_4(Dp.m5218constructorimpl((float) 0.0d)), null, 9, null);
    }

    public static final CornerBasedShape end(CornerBasedShape $this$end) {
        Intrinsics.checkNotNullParameter($this$end, "<this>");
        return CornerBasedShape.copy$default($this$end, CornerSizeKt.m729CornerSize0680j_4(Dp.m5218constructorimpl((float) 0.0d)), null, null, CornerSizeKt.m729CornerSize0680j_4(Dp.m5218constructorimpl((float) 0.0d)), 6, null);
    }

    public static final Shape fromToken(Shapes $this$fromToken, ShapeKeyTokens value) {
        Intrinsics.checkNotNullParameter($this$fromToken, "<this>");
        Intrinsics.checkNotNullParameter(value, "value");
        switch (WhenMappings.$EnumSwitchMapping$0[value.ordinal()]) {
            case 1:
                return $this$fromToken.getExtraLarge();
            case 2:
                return top($this$fromToken.getExtraLarge());
            case 3:
                return $this$fromToken.getExtraSmall();
            case 4:
                return top($this$fromToken.getExtraSmall());
            case 5:
                return RoundedCornerShapeKt.getCircleShape();
            case 6:
                return $this$fromToken.getLarge();
            case 7:
                return end($this$fromToken.getLarge());
            case 8:
                return top($this$fromToken.getLarge());
            case 9:
                return $this$fromToken.getMedium();
            case 10:
                return RectangleShapeKt.getRectangleShape();
            case 11:
                return $this$fromToken.getSmall();
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public static final Shape toShape(ShapeKeyTokens $this$toShape, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$toShape, "<this>");
        ComposerKt.sourceInformationMarkerStart($composer, -612531606, "C(toShape)189@7718L6:Shapes.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-612531606, $changed, -1, "androidx.compose.material3.toShape (Shapes.kt:188)");
        }
        Shape fromToken = fromToken(MaterialTheme.INSTANCE.getShapes($composer, 6), $this$toShape);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return fromToken;
    }

    public static final ProvidableCompositionLocal<Shapes> getLocalShapes() {
        return LocalShapes;
    }
}
