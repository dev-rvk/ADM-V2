package androidx.compose.foundation.lazy;

import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LazyListHeaders.kt */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0004\u001aF\u0010\u0000\u001a\u0004\u0018\u00010\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\bH\u0000¨\u0006\f"}, d2 = {"findOrComposeLazyListHeader", "Landroidx/compose/foundation/lazy/LazyListMeasuredItem;", "composedVisibleItems", "", "itemProvider", "Landroidx/compose/foundation/lazy/LazyListMeasuredItemProvider;", "headerIndexes", "", "", "beforeContentPadding", "layoutWidth", "layoutHeight", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class LazyListHeadersKt {
    public static final LazyListMeasuredItem findOrComposeLazyListHeader(List<LazyListMeasuredItem> composedVisibleItems, LazyListMeasuredItemProvider itemProvider, List<Integer> headerIndexes, int beforeContentPadding, int layoutWidth, int layoutHeight) {
        int headerOffset;
        Intrinsics.checkNotNullParameter(composedVisibleItems, "composedVisibleItems");
        Intrinsics.checkNotNullParameter(itemProvider, "itemProvider");
        Intrinsics.checkNotNullParameter(headerIndexes, "headerIndexes");
        int currentHeaderOffset = Integer.MIN_VALUE;
        int nextHeaderOffset = Integer.MIN_VALUE;
        int currentHeaderListPosition = -1;
        int nextHeaderListPosition = -1;
        int firstVisible = ((LazyListMeasuredItem) CollectionsKt.first((List) composedVisibleItems)).getIndex();
        int size = headerIndexes.size();
        for (int index = 0; index < size && headerIndexes.get(index).intValue() <= firstVisible; index++) {
            currentHeaderListPosition = headerIndexes.get(index).intValue();
            int i = index + 1;
            nextHeaderListPosition = ((i < 0 || i > CollectionsKt.getLastIndex(headerIndexes)) ? -1 : headerIndexes.get(i)).intValue();
        }
        int indexInComposedVisibleItems = -1;
        int size2 = composedVisibleItems.size();
        for (int index$iv = 0; index$iv < size2; index$iv++) {
            Object item$iv = composedVisibleItems.get(index$iv);
            LazyListMeasuredItem item = (LazyListMeasuredItem) item$iv;
            int index2 = index$iv;
            if (item.getIndex() == currentHeaderListPosition) {
                indexInComposedVisibleItems = index2;
                currentHeaderOffset = item.getOffset();
            } else if (item.getIndex() == nextHeaderListPosition) {
                nextHeaderOffset = item.getOffset();
            }
        }
        if (currentHeaderListPosition == -1) {
            return null;
        }
        LazyListMeasuredItem measuredHeaderItem = itemProvider.getAndMeasure(currentHeaderListPosition);
        if (currentHeaderOffset != Integer.MIN_VALUE) {
            headerOffset = Math.max(-beforeContentPadding, currentHeaderOffset);
        } else {
            headerOffset = -beforeContentPadding;
        }
        if (nextHeaderOffset != Integer.MIN_VALUE) {
            headerOffset = Math.min(headerOffset, nextHeaderOffset - measuredHeaderItem.getSize());
        }
        measuredHeaderItem.position(headerOffset, layoutWidth, layoutHeight);
        if (indexInComposedVisibleItems != -1) {
            composedVisibleItems.set(indexInComposedVisibleItems, measuredHeaderItem);
        } else {
            composedVisibleItems.add(0, measuredHeaderItem);
        }
        return measuredHeaderItem;
    }
}
