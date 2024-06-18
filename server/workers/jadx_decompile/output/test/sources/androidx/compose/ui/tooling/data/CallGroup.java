package androidx.compose.ui.tooling.data;

import androidx.autofill.HintConstants;
import androidx.compose.ui.unit.IntRect;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SlotTree.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001Bi\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f\u0012\u000e\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u000f\u0012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00010\u000f\u0012\u0006\u0010\u0011\u001a\u00020\u0012¢\u0006\u0002\u0010\u0013R\u001a\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Landroidx/compose/ui/tooling/data/CallGroup;", "Landroidx/compose/ui/tooling/data/Group;", "key", "", HintConstants.AUTOFILL_HINT_NAME, "", "box", "Landroidx/compose/ui/unit/IntRect;", "location", "Landroidx/compose/ui/tooling/data/SourceLocation;", "identity", "parameters", "", "Landroidx/compose/ui/tooling/data/ParameterInformation;", "data", "", "children", "isInline", "", "(Ljava/lang/Object;Ljava/lang/String;Landroidx/compose/ui/unit/IntRect;Landroidx/compose/ui/tooling/data/SourceLocation;Ljava/lang/Object;Ljava/util/List;Ljava/util/Collection;Ljava/util/Collection;Z)V", "getParameters", "()Ljava/util/List;", "ui-tooling-data_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class CallGroup extends Group {
    public static final int $stable = 8;
    private final List<ParameterInformation> parameters;

    @Override // androidx.compose.ui.tooling.data.Group
    public List<ParameterInformation> getParameters() {
        return this.parameters;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CallGroup(Object key, String name, IntRect box, SourceLocation location, Object identity, List<ParameterInformation> parameters, Collection<? extends Object> data, Collection<? extends Group> children, boolean isInline) {
        super(key, name, location, identity, box, data, children, isInline, null);
        Intrinsics.checkNotNullParameter(box, "box");
        Intrinsics.checkNotNullParameter(parameters, "parameters");
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(children, "children");
        this.parameters = parameters;
    }
}
