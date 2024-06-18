package androidx.compose.ui.semantics;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.platform.ValueElementSequence;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* compiled from: SemanticsModifier.kt */
@Metadata(d1 = {"\u0000>\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u001a\b\u0010\u0003\u001a\u00020\u0004H\u0000\u001a\u0014\u0010\u0005\u001a\u00020\u0006*\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0002\u001a#\u0010\n\u001a\u00020\u000b*\u00020\u000b2\u0017\u0010\f\u001a\u0013\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00060\r¢\u0006\u0002\b\u000f\u001a-\u0010\u0010\u001a\u00020\u000b*\u00020\u000b2\b\b\u0002\u0010\u0011\u001a\u00020\u00122\u0017\u0010\f\u001a\u0013\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00060\r¢\u0006\u0002\b\u000f\"\u0012\u0010\u0000\u001a\u00060\u0001j\u0002`\u0002X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"lastIdentifier", "Ljava/util/concurrent/atomic/AtomicInteger;", "Landroidx/compose/ui/platform/AtomicInt;", "generateSemanticsId", "", "addSemanticsPropertiesFrom", "", "Landroidx/compose/ui/platform/InspectorInfo;", "semanticsConfiguration", "Landroidx/compose/ui/semantics/SemanticsConfiguration;", "clearAndSetSemantics", "Landroidx/compose/ui/Modifier;", "properties", "Lkotlin/Function1;", "Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;", "Lkotlin/ExtensionFunctionType;", "semantics", "mergeDescendants", "", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class SemanticsModifierKt {
    private static AtomicInteger lastIdentifier = new AtomicInteger(0);

    public static final int generateSemanticsId() {
        return lastIdentifier.addAndGet(1);
    }

    public static /* synthetic */ Modifier semantics$default(Modifier modifier, boolean z, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        return semantics(modifier, z, function1);
    }

    public static final Modifier semantics(Modifier $this$semantics, boolean mergeDescendants, Function1<? super SemanticsPropertyReceiver, Unit> properties) {
        Intrinsics.checkNotNullParameter($this$semantics, "<this>");
        Intrinsics.checkNotNullParameter(properties, "properties");
        return $this$semantics.then(new AppendedSemanticsElement(mergeDescendants, properties));
    }

    public static final Modifier clearAndSetSemantics(Modifier $this$clearAndSetSemantics, Function1<? super SemanticsPropertyReceiver, Unit> properties) {
        Intrinsics.checkNotNullParameter($this$clearAndSetSemantics, "<this>");
        Intrinsics.checkNotNullParameter(properties, "properties");
        return $this$clearAndSetSemantics.then(new ClearAndSetSemanticsElement(properties));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void addSemanticsPropertiesFrom(InspectorInfo $this$addSemanticsPropertiesFrom, SemanticsConfiguration semanticsConfiguration) {
        ValueElementSequence properties = $this$addSemanticsPropertiesFrom.getProperties();
        SemanticsConfiguration $this$associate$iv = semanticsConfiguration;
        int capacity$iv = RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault($this$associate$iv, 10)), 16);
        Map destination$iv$iv = new LinkedHashMap(capacity$iv);
        for (Object element$iv$iv : $this$associate$iv) {
            Map.Entry<? extends SemanticsPropertyKey<?>, ? extends Object> entry = (Map.Entry) element$iv$iv;
            SemanticsPropertyKey key = entry.getKey();
            Object value = entry.getValue();
            Pair pair = TuplesKt.to(key.getName(), value);
            destination$iv$iv.put(pair.getFirst(), pair.getSecond());
        }
        properties.set("properties", destination$iv$iv);
    }
}
