package androidx.compose.material3;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.Color;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: Switch.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u008a\u0001\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0003\u0012\u0006\u0010\u0010\u001a\u00020\u0003\u0012\u0006\u0010\u0011\u001a\u00020\u0003\u0012\u0006\u0010\u0012\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0002\u0010\u0013J(\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00030\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0018H\u0001ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u001bJ\u0013\u0010\u001c\u001a\u00020\u00182\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u001e\u001a\u00020\u001fH\u0016J(\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00030\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0018H\u0001ø\u0001\u0000¢\u0006\u0004\b!\u0010\u001bJ(\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00030\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0018H\u0001ø\u0001\u0000¢\u0006\u0004\b#\u0010\u001bJ(\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00030\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0018H\u0001ø\u0001\u0000¢\u0006\u0004\b%\u0010\u001bR\u0019\u0010\u0005\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0014R\u0019\u0010\u0006\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0014R\u0019\u0010\u0002\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0014R\u0019\u0010\u0004\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0014R\u0019\u0010\r\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0014R\u0019\u0010\u000e\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0014R\u0019\u0010\u000b\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0014R\u0019\u0010\f\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0014R\u0019\u0010\u0011\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0014R\u0019\u0010\u0012\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0014R\u0019\u0010\u000f\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0014R\u0019\u0010\u0010\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0014R\u0019\u0010\t\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0014R\u0019\u0010\n\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0014R\u0019\u0010\u0007\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0014R\u0019\u0010\b\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0014\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006&"}, d2 = {"Landroidx/compose/material3/SwitchColors;", "", "checkedThumbColor", "Landroidx/compose/ui/graphics/Color;", "checkedTrackColor", "checkedBorderColor", "checkedIconColor", "uncheckedThumbColor", "uncheckedTrackColor", "uncheckedBorderColor", "uncheckedIconColor", "disabledCheckedThumbColor", "disabledCheckedTrackColor", "disabledCheckedBorderColor", "disabledCheckedIconColor", "disabledUncheckedThumbColor", "disabledUncheckedTrackColor", "disabledUncheckedBorderColor", "disabledUncheckedIconColor", "(JJJJJJJJJJJJJJJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "J", "borderColor", "Landroidx/compose/runtime/State;", "enabled", "", "checked", "borderColor$material3_release", "(ZZLandroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "equals", "other", "hashCode", "", "iconColor", "iconColor$material3_release", "thumbColor", "thumbColor$material3_release", "trackColor", "trackColor$material3_release", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class SwitchColors {
    public static final int $stable = 0;
    private final long checkedBorderColor;
    private final long checkedIconColor;
    private final long checkedThumbColor;
    private final long checkedTrackColor;
    private final long disabledCheckedBorderColor;
    private final long disabledCheckedIconColor;
    private final long disabledCheckedThumbColor;
    private final long disabledCheckedTrackColor;
    private final long disabledUncheckedBorderColor;
    private final long disabledUncheckedIconColor;
    private final long disabledUncheckedThumbColor;
    private final long disabledUncheckedTrackColor;
    private final long uncheckedBorderColor;
    private final long uncheckedIconColor;
    private final long uncheckedThumbColor;
    private final long uncheckedTrackColor;

    public /* synthetic */ SwitchColors(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14, long j15, long j16, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, j3, j4, j5, j6, j7, j8, j9, j10, j11, j12, j13, j14, j15, j16);
    }

    private SwitchColors(long checkedThumbColor, long checkedTrackColor, long checkedBorderColor, long checkedIconColor, long uncheckedThumbColor, long uncheckedTrackColor, long uncheckedBorderColor, long uncheckedIconColor, long disabledCheckedThumbColor, long disabledCheckedTrackColor, long disabledCheckedBorderColor, long disabledCheckedIconColor, long disabledUncheckedThumbColor, long disabledUncheckedTrackColor, long disabledUncheckedBorderColor, long disabledUncheckedIconColor) {
        this.checkedThumbColor = checkedThumbColor;
        this.checkedTrackColor = checkedTrackColor;
        this.checkedBorderColor = checkedBorderColor;
        this.checkedIconColor = checkedIconColor;
        this.uncheckedThumbColor = uncheckedThumbColor;
        this.uncheckedTrackColor = uncheckedTrackColor;
        this.uncheckedBorderColor = uncheckedBorderColor;
        this.uncheckedIconColor = uncheckedIconColor;
        this.disabledCheckedThumbColor = disabledCheckedThumbColor;
        this.disabledCheckedTrackColor = disabledCheckedTrackColor;
        this.disabledCheckedBorderColor = disabledCheckedBorderColor;
        this.disabledCheckedIconColor = disabledCheckedIconColor;
        this.disabledUncheckedThumbColor = disabledUncheckedThumbColor;
        this.disabledUncheckedTrackColor = disabledUncheckedTrackColor;
        this.disabledUncheckedBorderColor = disabledUncheckedBorderColor;
        this.disabledUncheckedIconColor = disabledUncheckedIconColor;
    }

    public final State<Color> thumbColor$material3_release(boolean enabled, boolean checked, Composer $composer, int $changed) {
        long j;
        $composer.startReplaceableGroup(-1539933265);
        ComposerKt.sourceInformation($composer, "C(thumbColor)P(1)373@16263L253:Switch.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1539933265, $changed, -1, "androidx.compose.material3.SwitchColors.thumbColor (Switch.kt:372)");
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

    public final State<Color> trackColor$material3_release(boolean enabled, boolean checked, Composer $composer, int $changed) {
        long j;
        $composer.startReplaceableGroup(961511844);
        ComposerKt.sourceInformation($composer, "C(trackColor)P(1)390@16875L253:Switch.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(961511844, $changed, -1, "androidx.compose.material3.SwitchColors.trackColor (Switch.kt:389)");
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

    public final State<Color> borderColor$material3_release(boolean enabled, boolean checked, Composer $composer, int $changed) {
        long j;
        $composer.startReplaceableGroup(462653665);
        ComposerKt.sourceInformation($composer, "C(borderColor)P(1)407@17489L257:Switch.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(462653665, $changed, -1, "androidx.compose.material3.SwitchColors.borderColor (Switch.kt:406)");
        }
        if (enabled) {
            j = checked ? this.checkedBorderColor : this.uncheckedBorderColor;
        } else {
            j = checked ? this.disabledCheckedBorderColor : this.disabledUncheckedBorderColor;
        }
        State<Color> rememberUpdatedState = SnapshotStateKt.rememberUpdatedState(Color.m2939boximpl(j), $composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return rememberUpdatedState;
    }

    public final State<Color> iconColor$material3_release(boolean enabled, boolean checked, Composer $composer, int $changed) {
        long j;
        $composer.startReplaceableGroup(-153383122);
        ComposerKt.sourceInformation($composer, "C(iconColor)P(1)424@18072L249:Switch.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-153383122, $changed, -1, "androidx.compose.material3.SwitchColors.iconColor (Switch.kt:423)");
        }
        if (enabled) {
            j = checked ? this.checkedIconColor : this.uncheckedIconColor;
        } else {
            j = checked ? this.disabledCheckedIconColor : this.disabledUncheckedIconColor;
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
        if (other != null && (other instanceof SwitchColors) && Color.m2950equalsimpl0(this.checkedThumbColor, ((SwitchColors) other).checkedThumbColor) && Color.m2950equalsimpl0(this.checkedTrackColor, ((SwitchColors) other).checkedTrackColor) && Color.m2950equalsimpl0(this.checkedBorderColor, ((SwitchColors) other).checkedBorderColor) && Color.m2950equalsimpl0(this.checkedIconColor, ((SwitchColors) other).checkedIconColor) && Color.m2950equalsimpl0(this.uncheckedThumbColor, ((SwitchColors) other).uncheckedThumbColor) && Color.m2950equalsimpl0(this.uncheckedTrackColor, ((SwitchColors) other).uncheckedTrackColor) && Color.m2950equalsimpl0(this.uncheckedBorderColor, ((SwitchColors) other).uncheckedBorderColor) && Color.m2950equalsimpl0(this.uncheckedIconColor, ((SwitchColors) other).uncheckedIconColor) && Color.m2950equalsimpl0(this.disabledCheckedThumbColor, ((SwitchColors) other).disabledCheckedThumbColor) && Color.m2950equalsimpl0(this.disabledCheckedTrackColor, ((SwitchColors) other).disabledCheckedTrackColor) && Color.m2950equalsimpl0(this.disabledCheckedBorderColor, ((SwitchColors) other).disabledCheckedBorderColor) && Color.m2950equalsimpl0(this.disabledCheckedIconColor, ((SwitchColors) other).disabledCheckedIconColor) && Color.m2950equalsimpl0(this.disabledUncheckedThumbColor, ((SwitchColors) other).disabledUncheckedThumbColor) && Color.m2950equalsimpl0(this.disabledUncheckedTrackColor, ((SwitchColors) other).disabledUncheckedTrackColor) && Color.m2950equalsimpl0(this.disabledUncheckedBorderColor, ((SwitchColors) other).disabledUncheckedBorderColor) && Color.m2950equalsimpl0(this.disabledUncheckedIconColor, ((SwitchColors) other).disabledUncheckedIconColor)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int result = Color.m2956hashCodeimpl(this.checkedThumbColor);
        return (((((((((((((((((((((((((((((result * 31) + Color.m2956hashCodeimpl(this.checkedTrackColor)) * 31) + Color.m2956hashCodeimpl(this.checkedBorderColor)) * 31) + Color.m2956hashCodeimpl(this.checkedIconColor)) * 31) + Color.m2956hashCodeimpl(this.uncheckedThumbColor)) * 31) + Color.m2956hashCodeimpl(this.uncheckedTrackColor)) * 31) + Color.m2956hashCodeimpl(this.uncheckedBorderColor)) * 31) + Color.m2956hashCodeimpl(this.uncheckedIconColor)) * 31) + Color.m2956hashCodeimpl(this.disabledCheckedThumbColor)) * 31) + Color.m2956hashCodeimpl(this.disabledCheckedTrackColor)) * 31) + Color.m2956hashCodeimpl(this.disabledCheckedBorderColor)) * 31) + Color.m2956hashCodeimpl(this.disabledCheckedIconColor)) * 31) + Color.m2956hashCodeimpl(this.disabledUncheckedThumbColor)) * 31) + Color.m2956hashCodeimpl(this.disabledUncheckedTrackColor)) * 31) + Color.m2956hashCodeimpl(this.disabledUncheckedBorderColor)) * 31) + Color.m2956hashCodeimpl(this.disabledUncheckedIconColor);
    }
}
