package androidx.compose.ui.autofill;

import android.util.Log;
import android.util.SparseArray;
import android.view.ViewStructure;
import android.view.autofill.AutofillId;
import android.view.autofill.AutofillValue;
import androidx.compose.ui.geometry.Rect;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* compiled from: AndroidAutofill.android.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u001a\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0001\u001a\u0014\u0010\u0006\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\bH\u0001¨\u0006\t"}, d2 = {"performAutofill", "", "Landroidx/compose/ui/autofill/AndroidAutofill;", "values", "Landroid/util/SparseArray;", "Landroid/view/autofill/AutofillValue;", "populateViewStructure", "root", "Landroid/view/ViewStructure;", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class AndroidAutofill_androidKt {
    public static final void populateViewStructure(AndroidAutofill $this$populateViewStructure, ViewStructure root) {
        ViewStructure root2 = root;
        Intrinsics.checkNotNullParameter($this$populateViewStructure, "<this>");
        Intrinsics.checkNotNullParameter(root2, "root");
        int index = AutofillApi23Helper.INSTANCE.addChildCount(root2, $this$populateViewStructure.getAutofillTree().getChildren().size());
        for (Map.Entry<Integer, AutofillNode> entry : $this$populateViewStructure.getAutofillTree().getChildren().entrySet()) {
            int id = entry.getKey().intValue();
            AutofillNode autofillNode = entry.getValue();
            ViewStructure child = AutofillApi23Helper.INSTANCE.newChild(root2, index);
            if (child != null) {
                AutofillApi26Helper autofillApi26Helper = AutofillApi26Helper.INSTANCE;
                AutofillId autofillId = AutofillApi26Helper.INSTANCE.getAutofillId(root2);
                Intrinsics.checkNotNull(autofillId);
                autofillApi26Helper.setAutofillId(child, autofillId, id);
                AutofillApi23Helper.INSTANCE.setId(child, id, $this$populateViewStructure.getView().getContext().getPackageName(), null, null);
                AutofillApi26Helper.INSTANCE.setAutofillType(child, 1);
                AutofillApi26Helper autofillApi26Helper2 = AutofillApi26Helper.INSTANCE;
                List $this$fastMap$iv = autofillNode.getAutofillTypes();
                Collection target$iv = new ArrayList($this$fastMap$iv.size());
                int size = $this$fastMap$iv.size();
                for (int index$iv$iv = 0; index$iv$iv < size; index$iv$iv++) {
                    Object item$iv$iv = $this$fastMap$iv.get(index$iv$iv);
                    AutofillType it = (AutofillType) item$iv$iv;
                    target$iv.add(AndroidAutofillType_androidKt.getAndroidType(it));
                }
                Collection $this$toTypedArray$iv = (List) target$iv;
                autofillApi26Helper2.setAutofillHints(child, (String[]) $this$toTypedArray$iv.toArray(new String[0]));
                Rect boundingBox = autofillNode.getBoundingBox();
                if (boundingBox == null) {
                    Log.w("Autofill Warning", "Bounding box not set.\n                        Did you call perform autofillTree before the component was positioned? ");
                } else {
                    int left = MathKt.roundToInt(boundingBox.getLeft());
                    int top = MathKt.roundToInt(boundingBox.getTop());
                    int right = MathKt.roundToInt(boundingBox.getRight());
                    int bottom = MathKt.roundToInt(boundingBox.getBottom());
                    int width = right - left;
                    int height = bottom - top;
                    AutofillApi23Helper.INSTANCE.setDimens(child, left, top, 0, 0, width, height);
                }
            }
            index++;
            root2 = root;
        }
    }

    public static final void performAutofill(AndroidAutofill $this$performAutofill, SparseArray<AutofillValue> values) {
        Intrinsics.checkNotNullParameter($this$performAutofill, "<this>");
        Intrinsics.checkNotNullParameter(values, "values");
        int size = values.size();
        for (int index = 0; index < size; index++) {
            int itemId = values.keyAt(index);
            AutofillValue value = values.get(itemId);
            AutofillApi26Helper autofillApi26Helper = AutofillApi26Helper.INSTANCE;
            Intrinsics.checkNotNullExpressionValue(value, "value");
            if (autofillApi26Helper.isText(value)) {
                $this$performAutofill.getAutofillTree().performAutofill(itemId, AutofillApi26Helper.INSTANCE.textValue(value).toString());
            } else {
                if (AutofillApi26Helper.INSTANCE.isDate(value)) {
                    throw new NotImplementedError("An operation is not implemented: b/138604541: Add onFill() callback for date");
                }
                if (AutofillApi26Helper.INSTANCE.isList(value)) {
                    throw new NotImplementedError("An operation is not implemented: b/138604541: Add onFill() callback for list");
                }
                if (AutofillApi26Helper.INSTANCE.isToggle(value)) {
                    throw new NotImplementedError("An operation is not implemented: b/138604541:  Add onFill() callback for toggle");
                }
            }
        }
    }
}
