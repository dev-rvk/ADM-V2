package androidx.compose.material;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.Color;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: Chip.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001BP\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0002\u0010\fJ&\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00030\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\u0017ø\u0001\u0000¢\u0006\u0002\u0010\u0012J&\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\u0017ø\u0001\u0000¢\u0006\u0002\u0010\u0012J\u0013\u0010\u0013\u001a\u00020\u00102\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0096\u0002J\b\u0010\u0016\u001a\u00020\u0017H\u0016J&\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\u0017ø\u0001\u0000¢\u0006\u0002\u0010\u0012R\u0019\u0010\u0002\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\rR\u0019\u0010\u0004\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\rR\u0019\u0010\u0006\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\rR\u0019\u0010\u0007\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\rR\u0019\u0010\b\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\rR\u0019\u0010\u0005\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\rR\u0019\u0010\t\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\rR\u0019\u0010\n\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\rR\u0019\u0010\u000b\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\r\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0018"}, d2 = {"Landroidx/compose/material/DefaultSelectableChipColors;", "Landroidx/compose/material/SelectableChipColors;", "backgroundColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "leadingIconColor", "disabledBackgroundColor", "disabledContentColor", "disabledLeadingIconColor", "selectedBackgroundColor", "selectedContentColor", "selectedLeadingIconColor", "(JJJJJJJJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "J", "Landroidx/compose/runtime/State;", "enabled", "", "selected", "(ZZLandroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "equals", "other", "", "hashCode", "", "material_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
final class DefaultSelectableChipColors implements SelectableChipColors {
    private final long backgroundColor;
    private final long contentColor;
    private final long disabledBackgroundColor;
    private final long disabledContentColor;
    private final long disabledLeadingIconColor;
    private final long leadingIconColor;
    private final long selectedBackgroundColor;
    private final long selectedContentColor;
    private final long selectedLeadingIconColor;

    public /* synthetic */ DefaultSelectableChipColors(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, j3, j4, j5, j6, j7, j8, j9);
    }

    private DefaultSelectableChipColors(long backgroundColor, long contentColor, long leadingIconColor, long disabledBackgroundColor, long disabledContentColor, long disabledLeadingIconColor, long selectedBackgroundColor, long selectedContentColor, long selectedLeadingIconColor) {
        this.backgroundColor = backgroundColor;
        this.contentColor = contentColor;
        this.leadingIconColor = leadingIconColor;
        this.disabledBackgroundColor = disabledBackgroundColor;
        this.disabledContentColor = disabledContentColor;
        this.disabledLeadingIconColor = disabledLeadingIconColor;
        this.selectedBackgroundColor = selectedBackgroundColor;
        this.selectedContentColor = selectedContentColor;
        this.selectedLeadingIconColor = selectedLeadingIconColor;
    }

    @Override // androidx.compose.material.SelectableChipColors
    public State<Color> backgroundColor(boolean enabled, boolean selected, Composer $composer, int $changed) {
        long target;
        $composer.startReplaceableGroup(-403836585);
        ComposerKt.sourceInformation($composer, "C(backgroundColor)660@29019L28:Chip.kt#jmzs0o");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-403836585, $changed, -1, "androidx.compose.material.DefaultSelectableChipColors.backgroundColor (Chip.kt:654)");
        }
        if (enabled) {
            target = !selected ? this.backgroundColor : this.selectedBackgroundColor;
        } else {
            target = this.disabledBackgroundColor;
        }
        State<Color> rememberUpdatedState = SnapshotStateKt.rememberUpdatedState(Color.m2939boximpl(target), $composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return rememberUpdatedState;
    }

    @Override // androidx.compose.material.SelectableChipColors
    public State<Color> contentColor(boolean enabled, boolean selected, Composer $composer, int $changed) {
        long target;
        $composer.startReplaceableGroup(2025240134);
        ComposerKt.sourceInformation($composer, "C(contentColor)670@29331L28:Chip.kt#jmzs0o");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(2025240134, $changed, -1, "androidx.compose.material.DefaultSelectableChipColors.contentColor (Chip.kt:664)");
        }
        if (enabled) {
            target = !selected ? this.contentColor : this.selectedContentColor;
        } else {
            target = this.disabledContentColor;
        }
        State<Color> rememberUpdatedState = SnapshotStateKt.rememberUpdatedState(Color.m2939boximpl(target), $composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return rememberUpdatedState;
    }

    @Override // androidx.compose.material.SelectableChipColors
    public State<Color> leadingIconColor(boolean enabled, boolean selected, Composer $composer, int $changed) {
        long target;
        $composer.startReplaceableGroup(189838188);
        ComposerKt.sourceInformation($composer, "C(leadingIconColor)680@29659L28:Chip.kt#jmzs0o");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(189838188, $changed, -1, "androidx.compose.material.DefaultSelectableChipColors.leadingIconColor (Chip.kt:674)");
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

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || getClass() != other.getClass()) {
            return false;
        }
        if (Color.m2950equalsimpl0(this.backgroundColor, ((DefaultSelectableChipColors) other).backgroundColor) && Color.m2950equalsimpl0(this.contentColor, ((DefaultSelectableChipColors) other).contentColor) && Color.m2950equalsimpl0(this.leadingIconColor, ((DefaultSelectableChipColors) other).leadingIconColor) && Color.m2950equalsimpl0(this.disabledBackgroundColor, ((DefaultSelectableChipColors) other).disabledBackgroundColor) && Color.m2950equalsimpl0(this.disabledContentColor, ((DefaultSelectableChipColors) other).disabledContentColor) && Color.m2950equalsimpl0(this.disabledLeadingIconColor, ((DefaultSelectableChipColors) other).disabledLeadingIconColor) && Color.m2950equalsimpl0(this.selectedBackgroundColor, ((DefaultSelectableChipColors) other).selectedBackgroundColor) && Color.m2950equalsimpl0(this.selectedContentColor, ((DefaultSelectableChipColors) other).selectedContentColor) && Color.m2950equalsimpl0(this.selectedLeadingIconColor, ((DefaultSelectableChipColors) other).selectedLeadingIconColor)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int result = Color.m2956hashCodeimpl(this.backgroundColor);
        return (((((((((((((((result * 31) + Color.m2956hashCodeimpl(this.contentColor)) * 31) + Color.m2956hashCodeimpl(this.leadingIconColor)) * 31) + Color.m2956hashCodeimpl(this.disabledBackgroundColor)) * 31) + Color.m2956hashCodeimpl(this.disabledContentColor)) * 31) + Color.m2956hashCodeimpl(this.disabledLeadingIconColor)) * 31) + Color.m2956hashCodeimpl(this.selectedBackgroundColor)) * 31) + Color.m2956hashCodeimpl(this.selectedContentColor)) * 31) + Color.m2956hashCodeimpl(this.selectedLeadingIconColor);
    }
}
