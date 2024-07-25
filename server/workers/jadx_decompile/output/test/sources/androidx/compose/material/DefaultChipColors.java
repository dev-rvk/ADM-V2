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
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B8\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0002\u0010\tJ\u001e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b2\u0006\u0010\f\u001a\u00020\rH\u0017ø\u0001\u0000¢\u0006\u0002\u0010\u000eJ\u001e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b2\u0006\u0010\f\u001a\u00020\rH\u0017ø\u0001\u0000¢\u0006\u0002\u0010\u000eJ\u0013\u0010\u000f\u001a\u00020\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0096\u0002J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\u001e\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b2\u0006\u0010\f\u001a\u00020\rH\u0017ø\u0001\u0000¢\u0006\u0002\u0010\u000eR\u0019\u0010\u0002\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\nR\u0019\u0010\u0004\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\nR\u0019\u0010\u0006\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\nR\u0019\u0010\u0007\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\nR\u0019\u0010\b\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\nR\u0019\u0010\u0005\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\n\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0014"}, d2 = {"Landroidx/compose/material/DefaultChipColors;", "Landroidx/compose/material/ChipColors;", "backgroundColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "leadingIconContentColor", "disabledBackgroundColor", "disabledContentColor", "disabledLeadingIconContentColor", "(JJJJJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "J", "Landroidx/compose/runtime/State;", "enabled", "", "(ZLandroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "equals", "other", "", "hashCode", "", "material_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
final class DefaultChipColors implements ChipColors {
    private final long backgroundColor;
    private final long contentColor;
    private final long disabledBackgroundColor;
    private final long disabledContentColor;
    private final long disabledLeadingIconContentColor;
    private final long leadingIconContentColor;

    public /* synthetic */ DefaultChipColors(long j, long j2, long j3, long j4, long j5, long j6, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, j3, j4, j5, j6);
    }

    private DefaultChipColors(long backgroundColor, long contentColor, long leadingIconContentColor, long disabledBackgroundColor, long disabledContentColor, long disabledLeadingIconContentColor) {
        this.backgroundColor = backgroundColor;
        this.contentColor = contentColor;
        this.leadingIconContentColor = leadingIconContentColor;
        this.disabledBackgroundColor = disabledBackgroundColor;
        this.disabledContentColor = disabledContentColor;
        this.disabledLeadingIconContentColor = disabledLeadingIconContentColor;
    }

    @Override // androidx.compose.material.ChipColors
    public State<Color> backgroundColor(boolean enabled, Composer $composer, int $changed) {
        $composer.startReplaceableGroup(-1593588247);
        ComposerKt.sourceInformation($composer, "C(backgroundColor)593@26472L79:Chip.kt#jmzs0o");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1593588247, $changed, -1, "androidx.compose.material.DefaultChipColors.backgroundColor (Chip.kt:592)");
        }
        State<Color> rememberUpdatedState = SnapshotStateKt.rememberUpdatedState(Color.m2939boximpl(enabled ? this.backgroundColor : this.disabledBackgroundColor), $composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return rememberUpdatedState;
    }

    @Override // androidx.compose.material.ChipColors
    public State<Color> contentColor(boolean enabled, Composer $composer, int $changed) {
        $composer.startReplaceableGroup(483145880);
        ComposerKt.sourceInformation($composer, "C(contentColor)598@26654L73:Chip.kt#jmzs0o");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(483145880, $changed, -1, "androidx.compose.material.DefaultChipColors.contentColor (Chip.kt:597)");
        }
        State<Color> rememberUpdatedState = SnapshotStateKt.rememberUpdatedState(Color.m2939boximpl(enabled ? this.contentColor : this.disabledContentColor), $composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return rememberUpdatedState;
    }

    @Override // androidx.compose.material.ChipColors
    public State<Color> leadingIconContentColor(boolean enabled, Composer $composer, int $changed) {
        $composer.startReplaceableGroup(1955749013);
        ComposerKt.sourceInformation($composer, "C(leadingIconContentColor)603@26841L117:Chip.kt#jmzs0o");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1955749013, $changed, -1, "androidx.compose.material.DefaultChipColors.leadingIconContentColor (Chip.kt:602)");
        }
        State<Color> rememberUpdatedState = SnapshotStateKt.rememberUpdatedState(Color.m2939boximpl(enabled ? this.leadingIconContentColor : this.disabledLeadingIconContentColor), $composer, 0);
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
        if (Color.m2950equalsimpl0(this.backgroundColor, ((DefaultChipColors) other).backgroundColor) && Color.m2950equalsimpl0(this.contentColor, ((DefaultChipColors) other).contentColor) && Color.m2950equalsimpl0(this.leadingIconContentColor, ((DefaultChipColors) other).leadingIconContentColor) && Color.m2950equalsimpl0(this.disabledBackgroundColor, ((DefaultChipColors) other).disabledBackgroundColor) && Color.m2950equalsimpl0(this.disabledContentColor, ((DefaultChipColors) other).disabledContentColor) && Color.m2950equalsimpl0(this.disabledLeadingIconContentColor, ((DefaultChipColors) other).disabledLeadingIconContentColor)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int result = Color.m2956hashCodeimpl(this.backgroundColor);
        return (((((((((result * 31) + Color.m2956hashCodeimpl(this.contentColor)) * 31) + Color.m2956hashCodeimpl(this.leadingIconContentColor)) * 31) + Color.m2956hashCodeimpl(this.disabledBackgroundColor)) * 31) + Color.m2956hashCodeimpl(this.disabledContentColor)) * 31) + Color.m2956hashCodeimpl(this.disabledLeadingIconContentColor);
    }
}
