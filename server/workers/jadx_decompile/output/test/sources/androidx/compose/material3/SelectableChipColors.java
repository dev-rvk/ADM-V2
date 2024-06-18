package androidx.compose.material3;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.Color;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: Chip.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001Br\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0002\u0010\u0010J(\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00030\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014H\u0001ø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u0017J\u0013\u0010\u0018\u001a\u00020\u00142\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u001a\u001a\u00020\u001bH\u0016J(\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014H\u0001ø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u0017J(\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00030\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014H\u0001ø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u0017J(\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00030\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014H\u0001ø\u0001\u0000¢\u0006\u0004\b \u0010\u0017R\u0019\u0010\u0002\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0011R\u0019\u0010\u0007\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0011R\u0019\u0010\b\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0011R\u0019\u0010\t\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0011R\u0019\u0010\f\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0011R\u0019\u0010\n\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0011R\u0019\u0010\u0004\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0011R\u0019\u0010\u0005\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0011R\u0019\u0010\u000b\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0011R\u0019\u0010\r\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0011R\u0019\u0010\u000e\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0011R\u0019\u0010\u000f\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0011R\u0019\u0010\u0006\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0011\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006!"}, d2 = {"Landroidx/compose/material3/SelectableChipColors;", "", "containerColor", "Landroidx/compose/ui/graphics/Color;", "labelColor", "leadingIconColor", "trailingIconColor", "disabledContainerColor", "disabledLabelColor", "disabledLeadingIconColor", "disabledTrailingIconColor", "selectedContainerColor", "disabledSelectedContainerColor", "selectedLabelColor", "selectedLeadingIconColor", "selectedTrailingIconColor", "(JJJJJJJJJJJJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "J", "Landroidx/compose/runtime/State;", "enabled", "", "selected", "containerColor$material3_release", "(ZZLandroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "equals", "other", "hashCode", "", "labelColor$material3_release", "leadingIconContentColor", "leadingIconContentColor$material3_release", "trailingIconContentColor", "trailingIconContentColor$material3_release", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class SelectableChipColors {
    public static final int $stable = 0;
    private final long containerColor;
    private final long disabledContainerColor;
    private final long disabledLabelColor;
    private final long disabledLeadingIconColor;
    private final long disabledSelectedContainerColor;
    private final long disabledTrailingIconColor;
    private final long labelColor;
    private final long leadingIconColor;
    private final long selectedContainerColor;
    private final long selectedLabelColor;
    private final long selectedLeadingIconColor;
    private final long selectedTrailingIconColor;
    private final long trailingIconColor;

    public /* synthetic */ SelectableChipColors(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, j3, j4, j5, j6, j7, j8, j9, j10, j11, j12, j13);
    }

    private SelectableChipColors(long containerColor, long labelColor, long leadingIconColor, long trailingIconColor, long disabledContainerColor, long disabledLabelColor, long disabledLeadingIconColor, long disabledTrailingIconColor, long selectedContainerColor, long disabledSelectedContainerColor, long selectedLabelColor, long selectedLeadingIconColor, long selectedTrailingIconColor) {
        this.containerColor = containerColor;
        this.labelColor = labelColor;
        this.leadingIconColor = leadingIconColor;
        this.trailingIconColor = trailingIconColor;
        this.disabledContainerColor = disabledContainerColor;
        this.disabledLabelColor = disabledLabelColor;
        this.disabledLeadingIconColor = disabledLeadingIconColor;
        this.disabledTrailingIconColor = disabledTrailingIconColor;
        this.selectedContainerColor = selectedContainerColor;
        this.disabledSelectedContainerColor = disabledSelectedContainerColor;
        this.selectedLabelColor = selectedLabelColor;
        this.selectedLeadingIconColor = selectedLeadingIconColor;
        this.selectedTrailingIconColor = selectedTrailingIconColor;
    }

    public final State<Color> containerColor$material3_release(boolean enabled, boolean selected, Composer $composer, int $changed) {
        long target;
        $composer.startReplaceableGroup(-2126903408);
        ComposerKt.sourceInformation($composer, "C(containerColor)1881@87835L28:Chip.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2126903408, $changed, -1, "androidx.compose.material3.SelectableChipColors.containerColor (Chip.kt:1875)");
        }
        if (enabled) {
            target = !selected ? this.containerColor : this.selectedContainerColor;
        } else {
            target = selected ? this.disabledSelectedContainerColor : this.disabledContainerColor;
        }
        State<Color> rememberUpdatedState = SnapshotStateKt.rememberUpdatedState(Color.m2939boximpl(target), $composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return rememberUpdatedState;
    }

    public final State<Color> labelColor$material3_release(boolean enabled, boolean selected, Composer $composer, int $changed) {
        long target;
        $composer.startReplaceableGroup(-829231549);
        ComposerKt.sourceInformation($composer, "C(labelColor)1897@88352L28:Chip.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-829231549, $changed, -1, "androidx.compose.material3.SelectableChipColors.labelColor (Chip.kt:1891)");
        }
        if (enabled) {
            target = !selected ? this.labelColor : this.selectedLabelColor;
        } else {
            target = this.disabledLabelColor;
        }
        State<Color> rememberUpdatedState = SnapshotStateKt.rememberUpdatedState(Color.m2939boximpl(target), $composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return rememberUpdatedState;
    }

    public final State<Color> leadingIconContentColor$material3_release(boolean enabled, boolean selected, Composer $composer, int $changed) {
        long target;
        $composer.startReplaceableGroup(-1112029563);
        ComposerKt.sourceInformation($composer, "C(leadingIconContentColor)1913@88907L28:Chip.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1112029563, $changed, -1, "androidx.compose.material3.SelectableChipColors.leadingIconContentColor (Chip.kt:1907)");
        }
        if (enabled) {
            target = !selected ? this.leadingIconColor : this.selectedLeadingIconColor;
        } else {
            target = this.disabledLeadingIconColor;
        }
        State<Color> rememberUpdatedState = SnapshotStateKt.rememberUpdatedState(Color.m2939boximpl(target), $composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return rememberUpdatedState;
    }

    public final State<Color> trailingIconContentColor$material3_release(boolean enabled, boolean selected, Composer $composer, int $changed) {
        long target;
        $composer.startReplaceableGroup(963620819);
        ComposerKt.sourceInformation($composer, "C(trailingIconContentColor)1929@89467L28:Chip.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(963620819, $changed, -1, "androidx.compose.material3.SelectableChipColors.trailingIconContentColor (Chip.kt:1923)");
        }
        if (enabled) {
            target = !selected ? this.trailingIconColor : this.selectedTrailingIconColor;
        } else {
            target = this.disabledTrailingIconColor;
        }
        State<Color> rememberUpdatedState = SnapshotStateKt.rememberUpdatedState(Color.m2939boximpl(target), $composer, 0);
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
        if (other != null && (other instanceof SelectableChipColors) && Color.m2950equalsimpl0(this.containerColor, ((SelectableChipColors) other).containerColor) && Color.m2950equalsimpl0(this.labelColor, ((SelectableChipColors) other).labelColor) && Color.m2950equalsimpl0(this.leadingIconColor, ((SelectableChipColors) other).leadingIconColor) && Color.m2950equalsimpl0(this.trailingIconColor, ((SelectableChipColors) other).trailingIconColor) && Color.m2950equalsimpl0(this.disabledContainerColor, ((SelectableChipColors) other).disabledContainerColor) && Color.m2950equalsimpl0(this.disabledLabelColor, ((SelectableChipColors) other).disabledLabelColor) && Color.m2950equalsimpl0(this.disabledLeadingIconColor, ((SelectableChipColors) other).disabledLeadingIconColor) && Color.m2950equalsimpl0(this.disabledTrailingIconColor, ((SelectableChipColors) other).disabledTrailingIconColor) && Color.m2950equalsimpl0(this.selectedContainerColor, ((SelectableChipColors) other).selectedContainerColor) && Color.m2950equalsimpl0(this.disabledSelectedContainerColor, ((SelectableChipColors) other).disabledSelectedContainerColor) && Color.m2950equalsimpl0(this.selectedLabelColor, ((SelectableChipColors) other).selectedLabelColor) && Color.m2950equalsimpl0(this.selectedLeadingIconColor, ((SelectableChipColors) other).selectedLeadingIconColor) && Color.m2950equalsimpl0(this.selectedTrailingIconColor, ((SelectableChipColors) other).selectedTrailingIconColor)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int result = Color.m2956hashCodeimpl(this.containerColor);
        return (((((((((((((((((((((((result * 31) + Color.m2956hashCodeimpl(this.labelColor)) * 31) + Color.m2956hashCodeimpl(this.leadingIconColor)) * 31) + Color.m2956hashCodeimpl(this.trailingIconColor)) * 31) + Color.m2956hashCodeimpl(this.disabledContainerColor)) * 31) + Color.m2956hashCodeimpl(this.disabledLabelColor)) * 31) + Color.m2956hashCodeimpl(this.disabledLeadingIconColor)) * 31) + Color.m2956hashCodeimpl(this.disabledTrailingIconColor)) * 31) + Color.m2956hashCodeimpl(this.selectedContainerColor)) * 31) + Color.m2956hashCodeimpl(this.disabledSelectedContainerColor)) * 31) + Color.m2956hashCodeimpl(this.selectedLabelColor)) * 31) + Color.m2956hashCodeimpl(this.selectedLeadingIconColor)) * 31) + Color.m2956hashCodeimpl(this.selectedTrailingIconColor);
    }
}
