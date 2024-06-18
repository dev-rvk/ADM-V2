package androidx.compose.ui.platform;

import android.view.View;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.ui.input.nestedscroll.NestedScrollSource;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.ranges.RangesKt;

/* compiled from: NestedScrollInteropConnection.kt */
@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0001H\u0000\u001a\u0017\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\fH\u0007¢\u0006\u0002\u0010\r\u001a%\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0004H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013\u001a\f\u0010\u0014\u001a\u00020\u0001*\u00020\u0001H\u0002\u001a\f\u0010\u0015\u001a\u00020\u0001*\u00020\u0003H\u0002\u001a\u0019\u0010\u0016\u001a\u00020\u0003*\u00020\u0017H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0019\u001a\f\u0010\u001a\u001a\u00020\u0001*\u00020\u0001H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u001b\u0010\u0002\u001a\u00020\u0003*\u00020\u00048BX\u0082\u0004ø\u0001\u0000¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006\u001b"}, d2 = {"ScrollingAxesThreshold", "", "scrollAxes", "", "Landroidx/compose/ui/geometry/Offset;", "getScrollAxes-k-4lQ0M", "(J)I", "composeToViewOffset", "offset", "rememberNestedScrollInteropConnection", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "hostView", "Landroid/view/View;", "(Landroid/view/View;Landroidx/compose/runtime/Composer;II)Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "toOffset", "consumed", "", "available", "toOffset-Uv8p0NA", "([IJ)J", "ceilAwayFromZero", "reverseAxis", "toViewType", "Landroidx/compose/ui/input/nestedscroll/NestedScrollSource;", "toViewType-GyEprt8", "(I)I", "toViewVelocity", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class NestedScrollInteropConnectionKt {
    private static final float ScrollingAxesThreshold = 0.5f;

    private static final float ceilAwayFromZero(float $this$ceilAwayFromZero) {
        return (float) ($this$ceilAwayFromZero >= 0.0f ? Math.ceil($this$ceilAwayFromZero) : Math.floor($this$ceilAwayFromZero));
    }

    public static final int composeToViewOffset(float offset) {
        return ((int) ceilAwayFromZero(offset)) * (-1);
    }

    private static final float reverseAxis(int $this$reverseAxis) {
        return $this$reverseAxis * (-1.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float toViewVelocity(float $this$toViewVelocity) {
        return (-1.0f) * $this$toViewVelocity;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: toOffset-Uv8p0NA, reason: not valid java name */
    public static final long m4539toOffsetUv8p0NA(int[] consumed, long available) {
        float offsetX;
        float offsetY;
        if (Offset.m2710getXimpl(available) >= 0.0f) {
            offsetX = RangesKt.coerceAtMost(reverseAxis(consumed[0]), Offset.m2710getXimpl(available));
        } else {
            offsetX = RangesKt.coerceAtLeast(reverseAxis(consumed[0]), Offset.m2710getXimpl(available));
        }
        if (Offset.m2711getYimpl(available) >= 0.0f) {
            offsetY = RangesKt.coerceAtMost(reverseAxis(consumed[1]), Offset.m2711getYimpl(available));
        } else {
            offsetY = RangesKt.coerceAtLeast(reverseAxis(consumed[1]), Offset.m2711getYimpl(available));
        }
        return OffsetKt.Offset(offsetX, offsetY);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: toViewType-GyEprt8, reason: not valid java name */
    public static final int m4540toViewTypeGyEprt8(int $this$toViewType_u2dGyEprt8) {
        return NestedScrollSource.m3960equalsimpl0($this$toViewType_u2dGyEprt8, NestedScrollSource.INSTANCE.m3965getDragWNlRxjI()) ? 0 : 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getScrollAxes-k-4lQ0M, reason: not valid java name */
    public static final int m4538getScrollAxesk4lQ0M(long $this$scrollAxes) {
        int axes = 0;
        if (Math.abs(Offset.m2710getXimpl($this$scrollAxes)) >= 0.5f) {
            axes = 0 | 1;
        }
        if (Math.abs(Offset.m2711getYimpl($this$scrollAxes)) >= 0.5f) {
            return axes | 2;
        }
        return axes;
    }

    public static final NestedScrollConnection rememberNestedScrollInteropConnection(View hostView, Composer $composer, int $changed, int i) {
        Object value$iv$iv;
        $composer.startReplaceableGroup(1260107652);
        ComposerKt.sourceInformation($composer, "C(rememberNestedScrollInteropConnection)232@8144L7,233@8180L66:NestedScrollInteropConnection.kt#itgzvw");
        if ((i & 1) != 0) {
            ProvidableCompositionLocal<View> localView = AndroidCompositionLocals_androidKt.getLocalView();
            ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume = $composer.consume(localView);
            ComposerKt.sourceInformationMarkerEnd($composer);
            hostView = (View) consume;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1260107652, $changed, -1, "androidx.compose.ui.platform.rememberNestedScrollInteropConnection (NestedScrollInteropConnection.kt:231)");
        }
        $composer.startReplaceableGroup(1157296644);
        ComposerKt.sourceInformation($composer, "CC(remember)P(1):Composables.kt#9igjgp");
        boolean invalid$iv$iv = $composer.changed(hostView);
        Object it$iv$iv = $composer.rememberedValue();
        if (invalid$iv$iv || it$iv$iv == Composer.INSTANCE.getEmpty()) {
            value$iv$iv = new NestedScrollInteropConnection(hostView);
            $composer.updateRememberedValue(value$iv$iv);
        } else {
            value$iv$iv = it$iv$iv;
        }
        $composer.endReplaceableGroup();
        NestedScrollInteropConnection nestedScrollInteropConnection = (NestedScrollInteropConnection) value$iv$iv;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return nestedScrollInteropConnection;
    }
}
