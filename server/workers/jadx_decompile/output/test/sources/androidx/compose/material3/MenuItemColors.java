package androidx.compose.material3;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.Color;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: Menu.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B:\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0002\u0010\tJ\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u000e\u001a\u00020\u000fH\u0016J \u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00102\u0006\u0010\u0011\u001a\u00020\fH\u0001ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013J \u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00030\u00102\u0006\u0010\u0011\u001a\u00020\fH\u0001ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0013J \u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u00102\u0006\u0010\u0011\u001a\u00020\fH\u0001ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0013R\u0019\u0010\u0007\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\nR\u0019\u0010\u0006\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\nR\u0019\u0010\b\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\nR\u0019\u0010\u0004\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\nR\u0019\u0010\u0002\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\nR\u0019\u0010\u0005\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\n\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0016"}, d2 = {"Landroidx/compose/material3/MenuItemColors;", "", "textColor", "Landroidx/compose/ui/graphics/Color;", "leadingIconColor", "trailingIconColor", "disabledTextColor", "disabledLeadingIconColor", "disabledTrailingIconColor", "(JJJJJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "J", "equals", "", "other", "hashCode", "", "Landroidx/compose/runtime/State;", "enabled", "leadingIconColor$material3_release", "(ZLandroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "textColor$material3_release", "trailingIconColor$material3_release", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class MenuItemColors {
    public static final int $stable = 0;
    private final long disabledLeadingIconColor;
    private final long disabledTextColor;
    private final long disabledTrailingIconColor;
    private final long leadingIconColor;
    private final long textColor;
    private final long trailingIconColor;

    public /* synthetic */ MenuItemColors(long j, long j2, long j3, long j4, long j5, long j6, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, j3, j4, j5, j6);
    }

    private MenuItemColors(long textColor, long leadingIconColor, long trailingIconColor, long disabledTextColor, long disabledLeadingIconColor, long disabledTrailingIconColor) {
        this.textColor = textColor;
        this.leadingIconColor = leadingIconColor;
        this.trailingIconColor = trailingIconColor;
        this.disabledTextColor = disabledTextColor;
        this.disabledLeadingIconColor = disabledLeadingIconColor;
        this.disabledTrailingIconColor = disabledTrailingIconColor;
    }

    public final State<Color> textColor$material3_release(boolean enabled, Composer $composer, int $changed) {
        $composer.startReplaceableGroup(-1023108655);
        ComposerKt.sourceInformation($composer, "C(textColor)384@14802L67:Menu.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1023108655, $changed, -1, "androidx.compose.material3.MenuItemColors.textColor (Menu.kt:383)");
        }
        State<Color> rememberUpdatedState = SnapshotStateKt.rememberUpdatedState(Color.m2939boximpl(enabled ? this.textColor : this.disabledTextColor), $composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return rememberUpdatedState;
    }

    public final State<Color> leadingIconColor$material3_release(boolean enabled, Composer $composer, int $changed) {
        $composer.startReplaceableGroup(1521013607);
        ComposerKt.sourceInformation($composer, "C(leadingIconColor)394@15146L81:Menu.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1521013607, $changed, -1, "androidx.compose.material3.MenuItemColors.leadingIconColor (Menu.kt:393)");
        }
        State<Color> rememberUpdatedState = SnapshotStateKt.rememberUpdatedState(Color.m2939boximpl(enabled ? this.leadingIconColor : this.disabledLeadingIconColor), $composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return rememberUpdatedState;
    }

    public final State<Color> trailingIconColor$material3_release(boolean enabled, Composer $composer, int $changed) {
        $composer.startReplaceableGroup(1024062809);
        ComposerKt.sourceInformation($composer, "C(trailingIconColor)404@15506L83:Menu.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1024062809, $changed, -1, "androidx.compose.material3.MenuItemColors.trailingIconColor (Menu.kt:403)");
        }
        State<Color> rememberUpdatedState = SnapshotStateKt.rememberUpdatedState(Color.m2939boximpl(enabled ? this.trailingIconColor : this.disabledTrailingIconColor), $composer, 0);
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
        if (other != null && (other instanceof MenuItemColors) && Color.m2950equalsimpl0(this.textColor, ((MenuItemColors) other).textColor) && Color.m2950equalsimpl0(this.leadingIconColor, ((MenuItemColors) other).leadingIconColor) && Color.m2950equalsimpl0(this.trailingIconColor, ((MenuItemColors) other).trailingIconColor) && Color.m2950equalsimpl0(this.disabledTextColor, ((MenuItemColors) other).disabledTextColor) && Color.m2950equalsimpl0(this.disabledLeadingIconColor, ((MenuItemColors) other).disabledLeadingIconColor) && Color.m2950equalsimpl0(this.disabledTrailingIconColor, ((MenuItemColors) other).disabledTrailingIconColor)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int result = Color.m2956hashCodeimpl(this.textColor);
        return (((((((((result * 31) + Color.m2956hashCodeimpl(this.leadingIconColor)) * 31) + Color.m2956hashCodeimpl(this.trailingIconColor)) * 31) + Color.m2956hashCodeimpl(this.disabledTextColor)) * 31) + Color.m2956hashCodeimpl(this.disabledLeadingIconColor)) * 31) + Color.m2956hashCodeimpl(this.disabledTrailingIconColor);
    }
}
