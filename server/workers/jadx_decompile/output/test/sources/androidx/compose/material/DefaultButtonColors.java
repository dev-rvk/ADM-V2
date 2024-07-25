package androidx.compose.material;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.Color;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: Button.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B(\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0002\u0010\u0007J\u001e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00030\t2\u0006\u0010\n\u001a\u00020\u000bH\u0017ø\u0001\u0000¢\u0006\u0002\u0010\fJ\u001e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\t2\u0006\u0010\n\u001a\u00020\u000bH\u0017ø\u0001\u0000¢\u0006\u0002\u0010\fJ\u0013\u0010\r\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0096\u0002J\b\u0010\u0010\u001a\u00020\u0011H\u0016R\u0019\u0010\u0002\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\bR\u0019\u0010\u0004\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\bR\u0019\u0010\u0005\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\bR\u0019\u0010\u0006\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\b\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0012"}, d2 = {"Landroidx/compose/material/DefaultButtonColors;", "Landroidx/compose/material/ButtonColors;", "backgroundColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "disabledBackgroundColor", "disabledContentColor", "(JJJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "J", "Landroidx/compose/runtime/State;", "enabled", "", "(ZLandroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "equals", "other", "", "hashCode", "", "material_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
final class DefaultButtonColors implements ButtonColors {
    private final long backgroundColor;
    private final long contentColor;
    private final long disabledBackgroundColor;
    private final long disabledContentColor;

    public /* synthetic */ DefaultButtonColors(long j, long j2, long j3, long j4, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, j3, j4);
    }

    private DefaultButtonColors(long backgroundColor, long contentColor, long disabledBackgroundColor, long disabledContentColor) {
        this.backgroundColor = backgroundColor;
        this.contentColor = contentColor;
        this.disabledBackgroundColor = disabledBackgroundColor;
        this.disabledContentColor = disabledContentColor;
    }

    @Override // androidx.compose.material.ButtonColors
    public State<Color> backgroundColor(boolean enabled, Composer $composer, int $changed) {
        $composer.startReplaceableGroup(-655254499);
        ComposerKt.sourceInformation($composer, "C(backgroundColor)587@23484L79:Button.kt#jmzs0o");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-655254499, $changed, -1, "androidx.compose.material.DefaultButtonColors.backgroundColor (Button.kt:586)");
        }
        State<Color> rememberUpdatedState = SnapshotStateKt.rememberUpdatedState(Color.m2939boximpl(enabled ? this.backgroundColor : this.disabledBackgroundColor), $composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return rememberUpdatedState;
    }

    @Override // androidx.compose.material.ButtonColors
    public State<Color> contentColor(boolean enabled, Composer $composer, int $changed) {
        $composer.startReplaceableGroup(-2133647540);
        ComposerKt.sourceInformation($composer, "C(contentColor)592@23666L73:Button.kt#jmzs0o");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2133647540, $changed, -1, "androidx.compose.material.DefaultButtonColors.contentColor (Button.kt:591)");
        }
        State<Color> rememberUpdatedState = SnapshotStateKt.rememberUpdatedState(Color.m2939boximpl(enabled ? this.contentColor : this.disabledContentColor), $composer, 0);
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
        if (Color.m2950equalsimpl0(this.backgroundColor, ((DefaultButtonColors) other).backgroundColor) && Color.m2950equalsimpl0(this.contentColor, ((DefaultButtonColors) other).contentColor) && Color.m2950equalsimpl0(this.disabledBackgroundColor, ((DefaultButtonColors) other).disabledBackgroundColor) && Color.m2950equalsimpl0(this.disabledContentColor, ((DefaultButtonColors) other).disabledContentColor)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int result = Color.m2956hashCodeimpl(this.backgroundColor);
        return (((((result * 31) + Color.m2956hashCodeimpl(this.contentColor)) * 31) + Color.m2956hashCodeimpl(this.disabledBackgroundColor)) * 31) + Color.m2956hashCodeimpl(this.disabledContentColor);
    }
}
