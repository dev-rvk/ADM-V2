package androidx.compose.material;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.Color;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: Switch.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001BH\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0002\u0010\u000bJ\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0096\u0002J\b\u0010\u0011\u001a\u00020\u0012H\u0016J&\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00030\u00142\u0006\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u000eH\u0017ø\u0001\u0000¢\u0006\u0002\u0010\u0017J&\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00030\u00142\u0006\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u000eH\u0017ø\u0001\u0000¢\u0006\u0002\u0010\u0017R\u0019\u0010\u0002\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\fR\u0019\u0010\u0004\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\fR\u0019\u0010\u0007\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\fR\u0019\u0010\b\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\fR\u0019\u0010\t\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\fR\u0019\u0010\n\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\fR\u0019\u0010\u0005\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\fR\u0019\u0010\u0006\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\f\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0019"}, d2 = {"Landroidx/compose/material/DefaultSwitchColors;", "Landroidx/compose/material/SwitchColors;", "checkedThumbColor", "Landroidx/compose/ui/graphics/Color;", "checkedTrackColor", "uncheckedThumbColor", "uncheckedTrackColor", "disabledCheckedThumbColor", "disabledCheckedTrackColor", "disabledUncheckedThumbColor", "disabledUncheckedTrackColor", "(JJJJJJJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "J", "equals", "", "other", "", "hashCode", "", "thumbColor", "Landroidx/compose/runtime/State;", "enabled", "checked", "(ZZLandroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "trackColor", "material_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
final class DefaultSwitchColors implements SwitchColors {
    private final long checkedThumbColor;
    private final long checkedTrackColor;
    private final long disabledCheckedThumbColor;
    private final long disabledCheckedTrackColor;
    private final long disabledUncheckedThumbColor;
    private final long disabledUncheckedTrackColor;
    private final long uncheckedThumbColor;
    private final long uncheckedTrackColor;

    public /* synthetic */ DefaultSwitchColors(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, j3, j4, j5, j6, j7, j8);
    }

    private DefaultSwitchColors(long checkedThumbColor, long checkedTrackColor, long uncheckedThumbColor, long uncheckedTrackColor, long disabledCheckedThumbColor, long disabledCheckedTrackColor, long disabledUncheckedThumbColor, long disabledUncheckedTrackColor) {
        this.checkedThumbColor = checkedThumbColor;
        this.checkedTrackColor = checkedTrackColor;
        this.uncheckedThumbColor = uncheckedThumbColor;
        this.uncheckedTrackColor = uncheckedTrackColor;
        this.disabledCheckedThumbColor = disabledCheckedThumbColor;
        this.disabledCheckedTrackColor = disabledCheckedTrackColor;
        this.disabledUncheckedThumbColor = disabledUncheckedThumbColor;
        this.disabledUncheckedTrackColor = disabledUncheckedTrackColor;
    }

    @Override // androidx.compose.material.SwitchColors
    public State<Color> thumbColor(boolean enabled, boolean checked, Composer $composer, int $changed) {
        long j;
        $composer.startReplaceableGroup(-66424183);
        ComposerKt.sourceInformation($composer, "C(thumbColor)P(1)367@15293L253:Switch.kt#jmzs0o");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-66424183, $changed, -1, "androidx.compose.material.DefaultSwitchColors.thumbColor (Switch.kt:366)");
        }
        if (enabled) {
            j = checked ? this.checkedThumbColor : this.uncheckedThumbColor;
        } else {
            j = checked ? this.disabledCheckedThumbColor : this.disabledUncheckedThumbColor;
        }
        State<Color> rememberUpdatedState = SnapshotStateKt.rememberUpdatedState(Color.m2939boximpl(j), $composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return rememberUpdatedState;
    }

    @Override // androidx.compose.material.SwitchColors
    public State<Color> trackColor(boolean enabled, boolean checked, Composer $composer, int $changed) {
        long j;
        $composer.startReplaceableGroup(-1176343362);
        ComposerKt.sourceInformation($composer, "C(trackColor)P(1)378@15665L253:Switch.kt#jmzs0o");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1176343362, $changed, -1, "androidx.compose.material.DefaultSwitchColors.trackColor (Switch.kt:377)");
        }
        if (enabled) {
            j = checked ? this.checkedTrackColor : this.uncheckedTrackColor;
        } else {
            j = checked ? this.disabledCheckedTrackColor : this.disabledUncheckedTrackColor;
        }
        State<Color> rememberUpdatedState = SnapshotStateKt.rememberUpdatedState(Color.m2939boximpl(j), $composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return rememberUpdatedState;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || getClass() != other.getClass()) {
            return false;
        }
        if (Color.m2950equalsimpl0(this.checkedThumbColor, ((DefaultSwitchColors) other).checkedThumbColor) && Color.m2950equalsimpl0(this.checkedTrackColor, ((DefaultSwitchColors) other).checkedTrackColor) && Color.m2950equalsimpl0(this.uncheckedThumbColor, ((DefaultSwitchColors) other).uncheckedThumbColor) && Color.m2950equalsimpl0(this.uncheckedTrackColor, ((DefaultSwitchColors) other).uncheckedTrackColor) && Color.m2950equalsimpl0(this.disabledCheckedThumbColor, ((DefaultSwitchColors) other).disabledCheckedThumbColor) && Color.m2950equalsimpl0(this.disabledCheckedTrackColor, ((DefaultSwitchColors) other).disabledCheckedTrackColor) && Color.m2950equalsimpl0(this.disabledUncheckedThumbColor, ((DefaultSwitchColors) other).disabledUncheckedThumbColor) && Color.m2950equalsimpl0(this.disabledUncheckedTrackColor, ((DefaultSwitchColors) other).disabledUncheckedTrackColor)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int result = Color.m2956hashCodeimpl(this.checkedThumbColor);
        return (((((((((((((result * 31) + Color.m2956hashCodeimpl(this.checkedTrackColor)) * 31) + Color.m2956hashCodeimpl(this.uncheckedThumbColor)) * 31) + Color.m2956hashCodeimpl(this.uncheckedTrackColor)) * 31) + Color.m2956hashCodeimpl(this.disabledCheckedThumbColor)) * 31) + Color.m2956hashCodeimpl(this.disabledCheckedTrackColor)) * 31) + Color.m2956hashCodeimpl(this.disabledUncheckedThumbColor)) * 31) + Color.m2956hashCodeimpl(this.disabledUncheckedTrackColor);
    }
}
