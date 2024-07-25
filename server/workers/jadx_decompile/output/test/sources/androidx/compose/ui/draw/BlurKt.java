package androidx.compose.ui.draw;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Blur.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a+\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0006\u0010\u0007\u001a3\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\n\u0010\u000b\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\f"}, d2 = {"blur", "Landroidx/compose/ui/Modifier;", "radius", "Landroidx/compose/ui/unit/Dp;", "edgeTreatment", "Landroidx/compose/ui/draw/BlurredEdgeTreatment;", "blur-F8QBwvs", "(Landroidx/compose/ui/Modifier;FLandroidx/compose/ui/graphics/Shape;)Landroidx/compose/ui/Modifier;", "radiusX", "radiusY", "blur-1fqS-gw", "(Landroidx/compose/ui/Modifier;FFLandroidx/compose/ui/graphics/Shape;)Landroidx/compose/ui/Modifier;", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class BlurKt {
    /* renamed from: blur-1fqS-gw$default, reason: not valid java name */
    public static /* synthetic */ Modifier m2603blur1fqSgw$default(Modifier modifier, float f, float f2, BlurredEdgeTreatment blurredEdgeTreatment, int i, Object obj) {
        if ((i & 4) != 0) {
            blurredEdgeTreatment = BlurredEdgeTreatment.m2606boximpl(BlurredEdgeTreatment.INSTANCE.m2613getRectangleGoahg());
        }
        return m2602blur1fqSgw(modifier, f, f2, blurredEdgeTreatment.m2612unboximpl());
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0030, code lost:
    
        if (r2 <= 0) goto L10;
     */
    /* renamed from: blur-1fqS-gw, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final androidx.compose.ui.Modifier m2602blur1fqSgw(androidx.compose.ui.Modifier r9, final float r10, final float r11, final androidx.compose.ui.graphics.Shape r12) {
        /*
            java.lang.String r0 = "$this$blur"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            r0 = 0
            r1 = 0
            if (r12 == 0) goto L11
            r0 = 1
            androidx.compose.ui.graphics.TileMode$Companion r2 = androidx.compose.ui.graphics.TileMode.INSTANCE
            int r1 = r2.m3315getClamp3opZhB0()
            goto L18
        L11:
            r0 = 0
            androidx.compose.ui.graphics.TileMode$Companion r2 = androidx.compose.ui.graphics.TileMode.INSTANCE
            int r1 = r2.m3316getDecal3opZhB0()
        L18:
            r2 = 0
            r3 = 0
            float r4 = (float) r2
            float r2 = androidx.compose.ui.unit.Dp.m5218constructorimpl(r4)
            int r2 = androidx.compose.ui.unit.Dp.m5217compareTo0680j_4(r10, r2)
            if (r2 <= 0) goto L32
            r2 = 0
            r3 = 0
            float r4 = (float) r2
            float r2 = androidx.compose.ui.unit.Dp.m5218constructorimpl(r4)
            int r2 = androidx.compose.ui.unit.Dp.m5217compareTo0680j_4(r11, r2)
            if (r2 > 0) goto L34
        L32:
            if (r0 == 0) goto L46
        L34:
            androidx.compose.ui.draw.BlurKt$blur$1 r8 = new androidx.compose.ui.draw.BlurKt$blur$1
            r2 = r8
            r3 = r10
            r4 = r11
            r5 = r1
            r6 = r12
            r7 = r0
            r2.<init>()
            kotlin.jvm.functions.Function1 r8 = (kotlin.jvm.functions.Function1) r8
            androidx.compose.ui.Modifier r2 = androidx.compose.ui.graphics.GraphicsLayerModifierKt.graphicsLayer(r9, r8)
            goto L47
        L46:
            r2 = r9
        L47:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.draw.BlurKt.m2602blur1fqSgw(androidx.compose.ui.Modifier, float, float, androidx.compose.ui.graphics.Shape):androidx.compose.ui.Modifier");
    }

    /* renamed from: blur-F8QBwvs$default, reason: not valid java name */
    public static /* synthetic */ Modifier m2605blurF8QBwvs$default(Modifier modifier, float f, BlurredEdgeTreatment blurredEdgeTreatment, int i, Object obj) {
        if ((i & 2) != 0) {
            blurredEdgeTreatment = BlurredEdgeTreatment.m2606boximpl(BlurredEdgeTreatment.INSTANCE.m2613getRectangleGoahg());
        }
        return m2604blurF8QBwvs(modifier, f, blurredEdgeTreatment.m2612unboximpl());
    }

    /* renamed from: blur-F8QBwvs, reason: not valid java name */
    public static final Modifier m2604blurF8QBwvs(Modifier blur, float radius, Shape edgeTreatment) {
        Intrinsics.checkNotNullParameter(blur, "$this$blur");
        return m2602blur1fqSgw(blur, radius, radius, edgeTreatment);
    }
}
