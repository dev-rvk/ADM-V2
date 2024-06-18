package androidx.compose.material3;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.Color;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: NavigationDrawer.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001BH\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0002\u0010\u000bJ\u001e\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00030\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0017ø\u0001\u0000¢\u0006\u0002\u0010\u001aJ\u001e\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0017ø\u0001\u0000¢\u0006\u0002\u0010\u001aJ\u0013\u0010\u001c\u001a\u00020\u00192\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0096\u0002J\b\u0010\u001f\u001a\u00020 H\u0016J\u001e\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00030\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0017ø\u0001\u0000¢\u0006\u0002\u0010\u001aJ\u001e\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00030\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0017ø\u0001\u0000¢\u0006\u0002\u0010\u001aR\u001c\u0010\t\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u001c\u0010\u0007\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u000f\u0010\rR\u001c\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u0010\u0010\rR\u001c\u0010\u0005\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u0011\u0010\rR\u001c\u0010\n\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u0012\u0010\rR\u001c\u0010\b\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u0013\u0010\rR\u001c\u0010\u0004\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u0014\u0010\rR\u001c\u0010\u0006\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u0015\u0010\r\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006#"}, d2 = {"Landroidx/compose/material3/DefaultDrawerItemsColor;", "Landroidx/compose/material3/NavigationDrawerItemColors;", "selectedIconColor", "Landroidx/compose/ui/graphics/Color;", "unselectedIconColor", "selectedTextColor", "unselectedTextColor", "selectedContainerColor", "unselectedContainerColor", "selectedBadgeColor", "unselectedBadgeColor", "(JJJJJJJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getSelectedBadgeColor-0d7_KjU", "()J", "J", "getSelectedContainerColor-0d7_KjU", "getSelectedIconColor-0d7_KjU", "getSelectedTextColor-0d7_KjU", "getUnselectedBadgeColor-0d7_KjU", "getUnselectedContainerColor-0d7_KjU", "getUnselectedIconColor-0d7_KjU", "getUnselectedTextColor-0d7_KjU", "badgeColor", "Landroidx/compose/runtime/State;", "selected", "", "(ZLandroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "containerColor", "equals", "other", "", "hashCode", "", "iconColor", "textColor", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
final class DefaultDrawerItemsColor implements NavigationDrawerItemColors {
    private final long selectedBadgeColor;
    private final long selectedContainerColor;
    private final long selectedIconColor;
    private final long selectedTextColor;
    private final long unselectedBadgeColor;
    private final long unselectedContainerColor;
    private final long unselectedIconColor;
    private final long unselectedTextColor;

    public /* synthetic */ DefaultDrawerItemsColor(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, j3, j4, j5, j6, j7, j8);
    }

    private DefaultDrawerItemsColor(long selectedIconColor, long unselectedIconColor, long selectedTextColor, long unselectedTextColor, long selectedContainerColor, long unselectedContainerColor, long selectedBadgeColor, long unselectedBadgeColor) {
        this.selectedIconColor = selectedIconColor;
        this.unselectedIconColor = unselectedIconColor;
        this.selectedTextColor = selectedTextColor;
        this.unselectedTextColor = unselectedTextColor;
        this.selectedContainerColor = selectedContainerColor;
        this.unselectedContainerColor = unselectedContainerColor;
        this.selectedBadgeColor = selectedBadgeColor;
        this.unselectedBadgeColor = unselectedBadgeColor;
    }

    /* renamed from: getSelectedIconColor-0d7_KjU, reason: not valid java name and from getter */
    public final long getSelectedIconColor() {
        return this.selectedIconColor;
    }

    /* renamed from: getUnselectedIconColor-0d7_KjU, reason: not valid java name and from getter */
    public final long getUnselectedIconColor() {
        return this.unselectedIconColor;
    }

    /* renamed from: getSelectedTextColor-0d7_KjU, reason: not valid java name and from getter */
    public final long getSelectedTextColor() {
        return this.selectedTextColor;
    }

    /* renamed from: getUnselectedTextColor-0d7_KjU, reason: not valid java name and from getter */
    public final long getUnselectedTextColor() {
        return this.unselectedTextColor;
    }

    /* renamed from: getSelectedContainerColor-0d7_KjU, reason: not valid java name and from getter */
    public final long getSelectedContainerColor() {
        return this.selectedContainerColor;
    }

    /* renamed from: getUnselectedContainerColor-0d7_KjU, reason: not valid java name and from getter */
    public final long getUnselectedContainerColor() {
        return this.unselectedContainerColor;
    }

    /* renamed from: getSelectedBadgeColor-0d7_KjU, reason: not valid java name and from getter */
    public final long getSelectedBadgeColor() {
        return this.selectedBadgeColor;
    }

    /* renamed from: getUnselectedBadgeColor-0d7_KjU, reason: not valid java name and from getter */
    public final long getUnselectedBadgeColor() {
        return this.unselectedBadgeColor;
    }

    @Override // androidx.compose.material3.NavigationDrawerItemColors
    public State<Color> iconColor(boolean selected, Composer $composer, int $changed) {
        $composer.startReplaceableGroup(1141354218);
        ComposerKt.sourceInformation($composer, "C(iconColor)787@30572L78:NavigationDrawer.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1141354218, $changed, -1, "androidx.compose.material3.DefaultDrawerItemsColor.iconColor (NavigationDrawer.kt:786)");
        }
        State<Color> rememberUpdatedState = SnapshotStateKt.rememberUpdatedState(Color.m2939boximpl(selected ? this.selectedIconColor : this.unselectedIconColor), $composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return rememberUpdatedState;
    }

    @Override // androidx.compose.material3.NavigationDrawerItemColors
    public State<Color> textColor(boolean selected, Composer $composer, int $changed) {
        $composer.startReplaceableGroup(1275109558);
        ComposerKt.sourceInformation($composer, "C(textColor)792@30751L78:NavigationDrawer.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1275109558, $changed, -1, "androidx.compose.material3.DefaultDrawerItemsColor.textColor (NavigationDrawer.kt:791)");
        }
        State<Color> rememberUpdatedState = SnapshotStateKt.rememberUpdatedState(Color.m2939boximpl(selected ? this.selectedTextColor : this.unselectedTextColor), $composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return rememberUpdatedState;
    }

    @Override // androidx.compose.material3.NavigationDrawerItemColors
    public State<Color> containerColor(boolean selected, Composer $composer, int $changed) {
        $composer.startReplaceableGroup(-433512770);
        ComposerKt.sourceInformation($composer, "C(containerColor)797@30935L110:NavigationDrawer.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-433512770, $changed, -1, "androidx.compose.material3.DefaultDrawerItemsColor.containerColor (NavigationDrawer.kt:796)");
        }
        State<Color> rememberUpdatedState = SnapshotStateKt.rememberUpdatedState(Color.m2939boximpl(selected ? this.selectedContainerColor : this.unselectedContainerColor), $composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return rememberUpdatedState;
    }

    @Override // androidx.compose.material3.NavigationDrawerItemColors
    public State<Color> badgeColor(boolean selected, Composer $composer, int $changed) {
        $composer.startReplaceableGroup(-561675044);
        ComposerKt.sourceInformation($composer, "C(badgeColor)804@31147L102:NavigationDrawer.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-561675044, $changed, -1, "androidx.compose.material3.DefaultDrawerItemsColor.badgeColor (NavigationDrawer.kt:803)");
        }
        State<Color> rememberUpdatedState = SnapshotStateKt.rememberUpdatedState(Color.m2939boximpl(selected ? this.selectedBadgeColor : this.unselectedBadgeColor), $composer, 0);
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
        return (other instanceof DefaultDrawerItemsColor) && Color.m2950equalsimpl0(this.selectedIconColor, ((DefaultDrawerItemsColor) other).selectedIconColor) && Color.m2950equalsimpl0(this.unselectedIconColor, ((DefaultDrawerItemsColor) other).unselectedIconColor) && Color.m2950equalsimpl0(this.selectedTextColor, ((DefaultDrawerItemsColor) other).selectedTextColor) && Color.m2950equalsimpl0(this.unselectedTextColor, ((DefaultDrawerItemsColor) other).unselectedTextColor) && Color.m2950equalsimpl0(this.selectedContainerColor, ((DefaultDrawerItemsColor) other).selectedContainerColor) && Color.m2950equalsimpl0(this.unselectedContainerColor, ((DefaultDrawerItemsColor) other).unselectedContainerColor) && Color.m2950equalsimpl0(this.selectedBadgeColor, ((DefaultDrawerItemsColor) other).selectedBadgeColor) && Color.m2950equalsimpl0(this.unselectedBadgeColor, ((DefaultDrawerItemsColor) other).unselectedBadgeColor);
    }

    public int hashCode() {
        int result = Color.m2956hashCodeimpl(this.selectedIconColor);
        return (((((((((((((result * 31) + Color.m2956hashCodeimpl(this.unselectedIconColor)) * 31) + Color.m2956hashCodeimpl(this.selectedTextColor)) * 31) + Color.m2956hashCodeimpl(this.unselectedTextColor)) * 31) + Color.m2956hashCodeimpl(this.selectedContainerColor)) * 31) + Color.m2956hashCodeimpl(this.unselectedContainerColor)) * 31) + Color.m2956hashCodeimpl(this.selectedBadgeColor)) * 31) + Color.m2956hashCodeimpl(this.unselectedBadgeColor);
    }
}
