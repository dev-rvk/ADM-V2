package androidx.compose.foundation;

import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.semantics.Role;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Clickable.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001BL\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n\u0012\b\u0010\f\u001a\u0004\u0018\u00010\b\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000b0\nø\u0001\u0000¢\u0006\u0002\u0010\u000eJ\b\u0010\u000f\u001a\u00020\u0002H\u0016J\u0013\u0010\u0010\u001a\u00020\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0096\u0002J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\u0010\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u0002H\u0016J\f\u0010\u0017\u001a\u00020\u000b*\u00020\u0018H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0002\n\u0000\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0019"}, d2 = {"Landroidx/compose/foundation/ClickableSemanticsElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/foundation/ClickableSemanticsNode;", "enabled", "", "role", "Landroidx/compose/ui/semantics/Role;", "onLongClickLabel", "", "onLongClick", "Lkotlin/Function0;", "", "onClickLabel", "onClick", "(ZLandroidx/compose/ui/semantics/Role;Ljava/lang/String;Lkotlin/jvm/functions/Function0;Ljava/lang/String;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "create", "equals", "other", "", "hashCode", "", "update", "node", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
final class ClickableSemanticsElement extends ModifierNodeElement<ClickableSemanticsNode> {
    private final boolean enabled;
    private final Function0<Unit> onClick;
    private final String onClickLabel;
    private final Function0<Unit> onLongClick;
    private final String onLongClickLabel;
    private final Role role;

    public /* synthetic */ ClickableSemanticsElement(boolean z, Role role, String str, Function0 function0, String str2, Function0 function02, DefaultConstructorMarker defaultConstructorMarker) {
        this(z, role, str, function0, str2, function02);
    }

    private ClickableSemanticsElement(boolean enabled, Role role, String onLongClickLabel, Function0<Unit> function0, String onClickLabel, Function0<Unit> onClick) {
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        this.enabled = enabled;
        this.role = role;
        this.onLongClickLabel = onLongClickLabel;
        this.onLongClick = function0;
        this.onClickLabel = onClickLabel;
        this.onClick = onClick;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.compose.ui.node.ModifierNodeElement
    public ClickableSemanticsNode create() {
        return new ClickableSemanticsNode(this.enabled, this.onClickLabel, this.role, this.onClick, this.onLongClickLabel, this.onLongClick, null);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void update(ClickableSemanticsNode node) {
        Intrinsics.checkNotNullParameter(node, "node");
        node.m208updateUMe6uN4(this.enabled, this.onClickLabel, this.role, this.onClick, this.onLongClickLabel, this.onLongClick);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void inspectableProperties(InspectorInfo $this$inspectableProperties) {
        Intrinsics.checkNotNullParameter($this$inspectableProperties, "<this>");
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public int hashCode() {
        int result = Boolean.hashCode(this.enabled);
        int i = result * 31;
        Role role = this.role;
        int result2 = i + (role != null ? role.hashCode() : 0);
        int result3 = result2 * 31;
        String str = this.onLongClickLabel;
        int result4 = (result3 + (str != null ? str.hashCode() : 0)) * 31;
        Function0<Unit> function0 = this.onLongClick;
        int result5 = (result4 + (function0 != null ? function0.hashCode() : 0)) * 31;
        String str2 = this.onClickLabel;
        return ((result5 + (str2 != null ? str2.hashCode() : 0)) * 31) + this.onClick.hashCode();
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof ClickableSemanticsElement) && this.enabled == ((ClickableSemanticsElement) other).enabled && Intrinsics.areEqual(this.role, ((ClickableSemanticsElement) other).role) && Intrinsics.areEqual(this.onLongClickLabel, ((ClickableSemanticsElement) other).onLongClickLabel) && Intrinsics.areEqual(this.onLongClick, ((ClickableSemanticsElement) other).onLongClick) && Intrinsics.areEqual(this.onClickLabel, ((ClickableSemanticsElement) other).onClickLabel) && Intrinsics.areEqual(this.onClick, ((ClickableSemanticsElement) other).onClick);
    }
}
