package androidx.compose.ui.tooling.data;

import androidx.autofill.HintConstants;
import androidx.compose.ui.unit.IntRect;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.List;
import kotlin.Metadata;

/* compiled from: SlotTree.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\fR\u0014\u0010\r\u001a\u0004\u0018\u00010\u000eX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u0004\u0018\u00010\u0012X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u001aÀ\u0006\u0001"}, d2 = {"Landroidx/compose/ui/tooling/data/SourceContext;", "", "bounds", "Landroidx/compose/ui/unit/IntRect;", "getBounds", "()Landroidx/compose/ui/unit/IntRect;", "depth", "", "getDepth", "()I", "isInline", "", "()Z", "location", "Landroidx/compose/ui/tooling/data/SourceLocation;", "getLocation", "()Landroidx/compose/ui/tooling/data/SourceLocation;", HintConstants.AUTOFILL_HINT_NAME, "", "getName", "()Ljava/lang/String;", "parameters", "", "Landroidx/compose/ui/tooling/data/ParameterInformation;", "getParameters", "()Ljava/util/List;", "ui-tooling-data_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public interface SourceContext {
    IntRect getBounds();

    int getDepth();

    SourceLocation getLocation();

    String getName();

    List<ParameterInformation> getParameters();

    default boolean isInline() {
        return false;
    }
}
