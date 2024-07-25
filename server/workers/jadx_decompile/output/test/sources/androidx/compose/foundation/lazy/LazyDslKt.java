package androidx.compose.foundation.lazy;

import androidx.autofill.HintConstants;
import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.gestures.ScrollableDefaults;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.unit.Dp;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.profileinstaller.ProfileVerifier;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LazyDsl.kt */
@Metadata(d1 = {"\u0000\u008c\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001al\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\u0017\u0010\u0010\u001a\u0013\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00010\u0011¢\u0006\u0002\b\u0013H\u0007¢\u0006\u0002\u0010\u0014\u001av\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0015\u001a\u00020\t2\u0017\u0010\u0010\u001a\u0013\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00010\u0011¢\u0006\u0002\b\u0013H\u0007¢\u0006\u0002\u0010\u0016\u001al\u0010\u0017\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\u0017\u0010\u0010\u001a\u0013\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00010\u0011¢\u0006\u0002\b\u0013H\u0007¢\u0006\u0002\u0010\u001c\u001av\u0010\u0017\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0015\u001a\u00020\t2\u0017\u0010\u0010\u001a\u0013\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00010\u0011¢\u0006\u0002\b\u0013H\u0007¢\u0006\u0002\u0010\u001d\u001a¬\u0001\u0010\u001e\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u001f*\u00020\u00122\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u0002H\u001f0 2%\b\n\u0010!\u001a\u001f\u0012\u0013\u0012\u0011H\u001f¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b($\u0012\u0004\u0012\u00020%\u0018\u00010\u00112%\b\n\u0010&\u001a\u001f\u0012\u0013\u0012\u0011H\u001f¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b($\u0012\u0006\u0012\u0004\u0018\u00010%0\u001123\b\u0004\u0010'\u001a-\u0012\u0004\u0012\u00020)\u0012\u0013\u0012\u0011H\u001f¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b($\u0012\u0004\u0012\u00020\u00010(¢\u0006\u0002\b*¢\u0006\u0002\b\u0013H\u0086\bø\u0001\u0000¢\u0006\u0002\u0010+\u001a\u0085\u0001\u0010\u001e\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u001f*\u00020\u00122\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u0002H\u001f0 2%\b\n\u0010!\u001a\u001f\u0012\u0013\u0012\u0011H\u001f¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b($\u0012\u0004\u0012\u00020%\u0018\u00010\u001123\b\u0004\u0010'\u001a-\u0012\u0004\u0012\u00020)\u0012\u0013\u0012\u0011H\u001f¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b($\u0012\u0004\u0012\u00020\u00010(¢\u0006\u0002\b*¢\u0006\u0002\b\u0013H\u0087\bø\u0001\u0000¢\u0006\u0002\u0010,\u001a¬\u0001\u0010\u001e\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u001f*\u00020\u00122\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u0002H\u001f0-2%\b\n\u0010!\u001a\u001f\u0012\u0013\u0012\u0011H\u001f¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b($\u0012\u0004\u0012\u00020%\u0018\u00010\u00112%\b\n\u0010&\u001a\u001f\u0012\u0013\u0012\u0011H\u001f¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b($\u0012\u0006\u0012\u0004\u0018\u00010%0\u001123\b\u0004\u0010'\u001a-\u0012\u0004\u0012\u00020)\u0012\u0013\u0012\u0011H\u001f¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b($\u0012\u0004\u0012\u00020\u00010(¢\u0006\u0002\b*¢\u0006\u0002\b\u0013H\u0086\bø\u0001\u0000¢\u0006\u0002\u0010.\u001a\u0085\u0001\u0010\u001e\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u001f*\u00020\u00122\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u0002H\u001f0-2%\b\n\u0010!\u001a\u001f\u0012\u0013\u0012\u0011H\u001f¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b($\u0012\u0004\u0012\u00020%\u0018\u00010\u001123\b\u0004\u0010'\u001a-\u0012\u0004\u0012\u00020)\u0012\u0013\u0012\u0011H\u001f¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b($\u0012\u0004\u0012\u00020\u00010(¢\u0006\u0002\b*¢\u0006\u0002\b\u0013H\u0087\bø\u0001\u0000¢\u0006\u0002\u0010/\u001aë\u0001\u00100\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u001f*\u00020\u00122\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u0002H\u001f0 2:\b\n\u0010!\u001a4\u0012\u0013\u0012\u001101¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b(2\u0012\u0013\u0012\u0011H\u001f¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b($\u0012\u0004\u0012\u00020%\u0018\u00010(2:\b\u0006\u0010&\u001a4\u0012\u0013\u0012\u001101¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b(2\u0012\u0013\u0012\u0011H\u001f¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b($\u0012\u0006\u0012\u0004\u0018\u00010%0(2H\b\u0004\u0010'\u001aB\u0012\u0004\u0012\u00020)\u0012\u0013\u0012\u001101¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b(2\u0012\u0013\u0012\u0011H\u001f¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b($\u0012\u0004\u0012\u00020\u000103¢\u0006\u0002\b*¢\u0006\u0002\b\u0013H\u0086\bø\u0001\u0000¢\u0006\u0002\u00104\u001a¯\u0001\u00100\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u001f*\u00020\u00122\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u0002H\u001f0 2:\b\n\u0010!\u001a4\u0012\u0013\u0012\u001101¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b(2\u0012\u0013\u0012\u0011H\u001f¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b($\u0012\u0004\u0012\u00020%\u0018\u00010(2H\b\u0004\u0010'\u001aB\u0012\u0004\u0012\u00020)\u0012\u0013\u0012\u001101¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b(2\u0012\u0013\u0012\u0011H\u001f¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b($\u0012\u0004\u0012\u00020\u000103¢\u0006\u0002\b*¢\u0006\u0002\b\u0013H\u0087\bø\u0001\u0000¢\u0006\u0002\u00105\u001aë\u0001\u00100\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u001f*\u00020\u00122\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u0002H\u001f0-2:\b\n\u0010!\u001a4\u0012\u0013\u0012\u001101¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b(2\u0012\u0013\u0012\u0011H\u001f¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b($\u0012\u0004\u0012\u00020%\u0018\u00010(2:\b\u0006\u0010&\u001a4\u0012\u0013\u0012\u001101¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b(2\u0012\u0013\u0012\u0011H\u001f¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b($\u0012\u0006\u0012\u0004\u0018\u00010%0(2H\b\u0004\u0010'\u001aB\u0012\u0004\u0012\u00020)\u0012\u0013\u0012\u001101¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b(2\u0012\u0013\u0012\u0011H\u001f¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b($\u0012\u0004\u0012\u00020\u000103¢\u0006\u0002\b*¢\u0006\u0002\b\u0013H\u0086\bø\u0001\u0000¢\u0006\u0002\u00106\u001a¯\u0001\u00100\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u001f*\u00020\u00122\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u0002H\u001f0-2:\b\n\u0010!\u001a4\u0012\u0013\u0012\u001101¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b(2\u0012\u0013\u0012\u0011H\u001f¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b($\u0012\u0004\u0012\u00020%\u0018\u00010(2H\b\u0004\u0010'\u001aB\u0012\u0004\u0012\u00020)\u0012\u0013\u0012\u001101¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b(2\u0012\u0013\u0012\u0011H\u001f¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b($\u0012\u0004\u0012\u00020\u000103¢\u0006\u0002\b*¢\u0006\u0002\b\u0013H\u0087\bø\u0001\u0000¢\u0006\u0002\u00107\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u00068"}, d2 = {"LazyColumn", "", "modifier", "Landroidx/compose/ui/Modifier;", "state", "Landroidx/compose/foundation/lazy/LazyListState;", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "reverseLayout", "", "verticalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Vertical;", "horizontalAlignment", "Landroidx/compose/ui/Alignment$Horizontal;", "flingBehavior", "Landroidx/compose/foundation/gestures/FlingBehavior;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/lazy/LazyListScope;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/lazy/LazyListState;Landroidx/compose/foundation/layout/PaddingValues;ZLandroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/ui/Alignment$Horizontal;Landroidx/compose/foundation/gestures/FlingBehavior;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "userScrollEnabled", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/lazy/LazyListState;Landroidx/compose/foundation/layout/PaddingValues;ZLandroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/ui/Alignment$Horizontal;Landroidx/compose/foundation/gestures/FlingBehavior;ZLkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "LazyRow", "horizontalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "verticalAlignment", "Landroidx/compose/ui/Alignment$Vertical;", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/lazy/LazyListState;Landroidx/compose/foundation/layout/PaddingValues;ZLandroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/ui/Alignment$Vertical;Landroidx/compose/foundation/gestures/FlingBehavior;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/lazy/LazyListState;Landroidx/compose/foundation/layout/PaddingValues;ZLandroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/ui/Alignment$Vertical;Landroidx/compose/foundation/gestures/FlingBehavior;ZLkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "items", "T", "", "key", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, "item", "", "contentType", "itemContent", "Lkotlin/Function2;", "Landroidx/compose/foundation/lazy/LazyItemScope;", "Landroidx/compose/runtime/Composable;", "(Landroidx/compose/foundation/lazy/LazyListScope;[Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function4;)V", "(Landroidx/compose/foundation/lazy/LazyListScope;[Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function4;)V", "", "(Landroidx/compose/foundation/lazy/LazyListScope;Ljava/util/List;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function4;)V", "(Landroidx/compose/foundation/lazy/LazyListScope;Ljava/util/List;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function4;)V", "itemsIndexed", "", "index", "Lkotlin/Function3;", "(Landroidx/compose/foundation/lazy/LazyListScope;[Ljava/lang/Object;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function5;)V", "(Landroidx/compose/foundation/lazy/LazyListScope;[Ljava/lang/Object;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function5;)V", "(Landroidx/compose/foundation/lazy/LazyListScope;Ljava/util/List;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function5;)V", "(Landroidx/compose/foundation/lazy/LazyListScope;Ljava/util/List;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function5;)V", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class LazyDslKt {
    public static /* synthetic */ void items$default(LazyListScope $this$items_u24default, List items, Function1 key, Function1 contentType, Function4 itemContent, int i, Object obj) {
        LazyDslKt$items$2 lazyDslKt$items$2;
        if ((i & 2) != 0) {
            key = null;
        }
        if ((i & 4) != 0) {
            Function1 contentType2 = LazyDslKt$items$1.INSTANCE;
            contentType = contentType2;
        }
        Intrinsics.checkNotNullParameter($this$items_u24default, "<this>");
        Intrinsics.checkNotNullParameter(items, "items");
        Intrinsics.checkNotNullParameter(contentType, "contentType");
        Intrinsics.checkNotNullParameter(itemContent, "itemContent");
        int size = items.size();
        if (key != null) {
            lazyDslKt$items$2 = new LazyDslKt$items$2(key, items);
        } else {
            lazyDslKt$items$2 = null;
        }
        $this$items_u24default.items(size, lazyDslKt$items$2, new LazyDslKt$items$3(contentType, items), ComposableLambdaKt.composableLambdaInstance(-632812321, true, new LazyDslKt$items$4(itemContent, items)));
    }

    public static final <T> void items(LazyListScope $this$items, List<? extends T> items, Function1<? super T, ? extends Object> function1, Function1<? super T, ? extends Object> contentType, Function4<? super LazyItemScope, ? super T, ? super Composer, ? super Integer, Unit> itemContent) {
        LazyDslKt$items$2 lazyDslKt$items$2;
        Intrinsics.checkNotNullParameter($this$items, "<this>");
        Intrinsics.checkNotNullParameter(items, "items");
        Intrinsics.checkNotNullParameter(contentType, "contentType");
        Intrinsics.checkNotNullParameter(itemContent, "itemContent");
        int size = items.size();
        if (function1 != null) {
            lazyDslKt$items$2 = new LazyDslKt$items$2(function1, items);
        } else {
            lazyDslKt$items$2 = null;
        }
        $this$items.items(size, lazyDslKt$items$2, new LazyDslKt$items$3(contentType, items), ComposableLambdaKt.composableLambdaInstance(-632812321, true, new LazyDslKt$items$4(itemContent, items)));
    }

    public static /* synthetic */ void items$default(LazyListScope $this$items_u24default, List items, Function1 key, Function4 itemContent, int i, Object obj) {
        LazyDslKt$items$2 lazyDslKt$items$2;
        if ((i & 2) != 0) {
            key = null;
        }
        Intrinsics.checkNotNullParameter($this$items_u24default, "<this>");
        Intrinsics.checkNotNullParameter(items, "items");
        Intrinsics.checkNotNullParameter(itemContent, "itemContent");
        Function1 contentType$iv = LazyDslKt$items$1.INSTANCE;
        int size = items.size();
        if (key != null) {
            lazyDslKt$items$2 = new LazyDslKt$items$2(key, items);
        } else {
            lazyDslKt$items$2 = null;
        }
        $this$items_u24default.items(size, lazyDslKt$items$2, new LazyDslKt$items$3(contentType$iv, items), ComposableLambdaKt.composableLambdaInstance(-632812321, true, new LazyDslKt$items$4(itemContent, items)));
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Use the non deprecated overload")
    public static final /* synthetic */ <T> void items(LazyListScope $this$items, List<? extends T> items, Function1<? super T, ? extends Object> function1, Function4<? super LazyItemScope, ? super T, ? super Composer, ? super Integer, Unit> itemContent) {
        LazyDslKt$items$2 lazyDslKt$items$2;
        Intrinsics.checkNotNullParameter($this$items, "<this>");
        Intrinsics.checkNotNullParameter(items, "items");
        Intrinsics.checkNotNullParameter(itemContent, "itemContent");
        Function1 contentType$iv = LazyDslKt$items$1.INSTANCE;
        int size = items.size();
        if (function1 != null) {
            lazyDslKt$items$2 = new LazyDslKt$items$2(function1, items);
        } else {
            lazyDslKt$items$2 = null;
        }
        $this$items.items(size, lazyDslKt$items$2, new LazyDslKt$items$3(contentType$iv, items), ComposableLambdaKt.composableLambdaInstance(-632812321, true, new LazyDslKt$items$4(itemContent, items)));
    }

    public static /* synthetic */ void itemsIndexed$default(LazyListScope $this$itemsIndexed_u24default, List items, Function2 key, Function2 contentType, Function5 itemContent, int i, Object obj) {
        LazyDslKt$itemsIndexed$2 lazyDslKt$itemsIndexed$2;
        if ((i & 2) != 0) {
            key = null;
        }
        if ((i & 4) != 0) {
            Function2 contentType2 = new Function2() { // from class: androidx.compose.foundation.lazy.LazyDslKt$itemsIndexed$1
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2) {
                    return invoke(((Number) p1).intValue(), (int) p2);
                }

                public final Void invoke(int i2, T t) {
                    return null;
                }
            };
            contentType = contentType2;
        }
        Intrinsics.checkNotNullParameter($this$itemsIndexed_u24default, "<this>");
        Intrinsics.checkNotNullParameter(items, "items");
        Intrinsics.checkNotNullParameter(contentType, "contentType");
        Intrinsics.checkNotNullParameter(itemContent, "itemContent");
        int size = items.size();
        if (key != null) {
            lazyDslKt$itemsIndexed$2 = new LazyDslKt$itemsIndexed$2(key, items);
        } else {
            lazyDslKt$itemsIndexed$2 = null;
        }
        $this$itemsIndexed_u24default.items(size, lazyDslKt$itemsIndexed$2, new LazyDslKt$itemsIndexed$3(contentType, items), ComposableLambdaKt.composableLambdaInstance(-1091073711, true, new LazyDslKt$itemsIndexed$4(itemContent, items)));
    }

    public static final <T> void itemsIndexed(LazyListScope $this$itemsIndexed, List<? extends T> items, Function2<? super Integer, ? super T, ? extends Object> function2, Function2<? super Integer, ? super T, ? extends Object> contentType, Function5<? super LazyItemScope, ? super Integer, ? super T, ? super Composer, ? super Integer, Unit> itemContent) {
        LazyDslKt$itemsIndexed$2 lazyDslKt$itemsIndexed$2;
        Intrinsics.checkNotNullParameter($this$itemsIndexed, "<this>");
        Intrinsics.checkNotNullParameter(items, "items");
        Intrinsics.checkNotNullParameter(contentType, "contentType");
        Intrinsics.checkNotNullParameter(itemContent, "itemContent");
        int size = items.size();
        if (function2 != null) {
            lazyDslKt$itemsIndexed$2 = new LazyDslKt$itemsIndexed$2(function2, items);
        } else {
            lazyDslKt$itemsIndexed$2 = null;
        }
        $this$itemsIndexed.items(size, lazyDslKt$itemsIndexed$2, new LazyDslKt$itemsIndexed$3(contentType, items), ComposableLambdaKt.composableLambdaInstance(-1091073711, true, new LazyDslKt$itemsIndexed$4(itemContent, items)));
    }

    public static /* synthetic */ void itemsIndexed$default(LazyListScope $this$itemsIndexed_u24default, List items, Function2 key, Function5 itemContent, int i, Object obj) {
        LazyDslKt$itemsIndexed$2 lazyDslKt$itemsIndexed$2;
        if ((i & 2) != 0) {
            key = null;
        }
        Intrinsics.checkNotNullParameter($this$itemsIndexed_u24default, "<this>");
        Intrinsics.checkNotNullParameter(items, "items");
        Intrinsics.checkNotNullParameter(itemContent, "itemContent");
        int size = items.size();
        if (key != null) {
            lazyDslKt$itemsIndexed$2 = new LazyDslKt$itemsIndexed$2(key, items);
        } else {
            lazyDslKt$itemsIndexed$2 = null;
        }
        $this$itemsIndexed_u24default.items(size, lazyDslKt$itemsIndexed$2, new LazyDslKt$itemsIndexed$$inlined$itemsIndexed$default$1(items), ComposableLambdaKt.composableLambdaInstance(-1091073711, true, new LazyDslKt$itemsIndexed$4(itemContent, items)));
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Use the non deprecated overload")
    public static final /* synthetic */ <T> void itemsIndexed(LazyListScope $this$itemsIndexed, List<? extends T> items, Function2<? super Integer, ? super T, ? extends Object> function2, Function5<? super LazyItemScope, ? super Integer, ? super T, ? super Composer, ? super Integer, Unit> itemContent) {
        LazyDslKt$itemsIndexed$2 lazyDslKt$itemsIndexed$2;
        Intrinsics.checkNotNullParameter($this$itemsIndexed, "<this>");
        Intrinsics.checkNotNullParameter(items, "items");
        Intrinsics.checkNotNullParameter(itemContent, "itemContent");
        int size = items.size();
        if (function2 != null) {
            lazyDslKt$itemsIndexed$2 = new LazyDslKt$itemsIndexed$2(function2, items);
        } else {
            lazyDslKt$itemsIndexed$2 = null;
        }
        $this$itemsIndexed.items(size, lazyDslKt$itemsIndexed$2, new LazyDslKt$itemsIndexed$$inlined$itemsIndexed$default$1(items), ComposableLambdaKt.composableLambdaInstance(-1091073711, true, new LazyDslKt$itemsIndexed$4(itemContent, items)));
    }

    public static /* synthetic */ void items$default(LazyListScope $this$items_u24default, Object[] items, Function1 key, Function1 contentType, Function4 itemContent, int i, Object obj) {
        LazyDslKt$items$6 lazyDslKt$items$6;
        if ((i & 2) != 0) {
            key = null;
        }
        if ((i & 4) != 0) {
            Function1 contentType2 = LazyDslKt$items$5.INSTANCE;
            contentType = contentType2;
        }
        Intrinsics.checkNotNullParameter($this$items_u24default, "<this>");
        Intrinsics.checkNotNullParameter(items, "items");
        Intrinsics.checkNotNullParameter(contentType, "contentType");
        Intrinsics.checkNotNullParameter(itemContent, "itemContent");
        int length = items.length;
        if (key != null) {
            lazyDslKt$items$6 = new LazyDslKt$items$6(key, items);
        } else {
            lazyDslKt$items$6 = null;
        }
        $this$items_u24default.items(length, lazyDslKt$items$6, new LazyDslKt$items$7(contentType, items), ComposableLambdaKt.composableLambdaInstance(-1043393750, true, new LazyDslKt$items$8(itemContent, items)));
    }

    public static final <T> void items(LazyListScope $this$items, T[] items, Function1<? super T, ? extends Object> function1, Function1<? super T, ? extends Object> contentType, Function4<? super LazyItemScope, ? super T, ? super Composer, ? super Integer, Unit> itemContent) {
        LazyDslKt$items$6 lazyDslKt$items$6;
        Intrinsics.checkNotNullParameter($this$items, "<this>");
        Intrinsics.checkNotNullParameter(items, "items");
        Intrinsics.checkNotNullParameter(contentType, "contentType");
        Intrinsics.checkNotNullParameter(itemContent, "itemContent");
        int length = items.length;
        if (function1 != null) {
            lazyDslKt$items$6 = new LazyDslKt$items$6(function1, items);
        } else {
            lazyDslKt$items$6 = null;
        }
        $this$items.items(length, lazyDslKt$items$6, new LazyDslKt$items$7(contentType, items), ComposableLambdaKt.composableLambdaInstance(-1043393750, true, new LazyDslKt$items$8(itemContent, items)));
    }

    public static /* synthetic */ void items$default(LazyListScope $this$items_u24default, Object[] items, Function1 key, Function4 itemContent, int i, Object obj) {
        LazyDslKt$items$6 lazyDslKt$items$6;
        if ((i & 2) != 0) {
            key = null;
        }
        Intrinsics.checkNotNullParameter($this$items_u24default, "<this>");
        Intrinsics.checkNotNullParameter(items, "items");
        Intrinsics.checkNotNullParameter(itemContent, "itemContent");
        Function1 contentType$iv = LazyDslKt$items$5.INSTANCE;
        int length = items.length;
        if (key != null) {
            lazyDslKt$items$6 = new LazyDslKt$items$6(key, items);
        } else {
            lazyDslKt$items$6 = null;
        }
        $this$items_u24default.items(length, lazyDslKt$items$6, new LazyDslKt$items$7(contentType$iv, items), ComposableLambdaKt.composableLambdaInstance(-1043393750, true, new LazyDslKt$items$8(itemContent, items)));
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Use the non deprecated overload")
    public static final /* synthetic */ <T> void items(LazyListScope $this$items, T[] items, Function1<? super T, ? extends Object> function1, Function4<? super LazyItemScope, ? super T, ? super Composer, ? super Integer, Unit> itemContent) {
        LazyDslKt$items$6 lazyDslKt$items$6;
        Intrinsics.checkNotNullParameter($this$items, "<this>");
        Intrinsics.checkNotNullParameter(items, "items");
        Intrinsics.checkNotNullParameter(itemContent, "itemContent");
        Function1 contentType$iv = LazyDslKt$items$5.INSTANCE;
        int length = items.length;
        if (function1 != null) {
            lazyDslKt$items$6 = new LazyDslKt$items$6(function1, items);
        } else {
            lazyDslKt$items$6 = null;
        }
        $this$items.items(length, lazyDslKt$items$6, new LazyDslKt$items$7(contentType$iv, items), ComposableLambdaKt.composableLambdaInstance(-1043393750, true, new LazyDslKt$items$8(itemContent, items)));
    }

    public static /* synthetic */ void itemsIndexed$default(LazyListScope $this$itemsIndexed_u24default, Object[] items, Function2 key, Function2 contentType, Function5 itemContent, int i, Object obj) {
        LazyDslKt$itemsIndexed$6 lazyDslKt$itemsIndexed$6;
        if ((i & 2) != 0) {
            key = null;
        }
        if ((i & 4) != 0) {
            Function2 contentType2 = new Function2() { // from class: androidx.compose.foundation.lazy.LazyDslKt$itemsIndexed$5
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2) {
                    return invoke(((Number) p1).intValue(), (int) p2);
                }

                public final Void invoke(int i2, T t) {
                    return null;
                }
            };
            contentType = contentType2;
        }
        Intrinsics.checkNotNullParameter($this$itemsIndexed_u24default, "<this>");
        Intrinsics.checkNotNullParameter(items, "items");
        Intrinsics.checkNotNullParameter(contentType, "contentType");
        Intrinsics.checkNotNullParameter(itemContent, "itemContent");
        int length = items.length;
        if (key != null) {
            lazyDslKt$itemsIndexed$6 = new LazyDslKt$itemsIndexed$6(key, items);
        } else {
            lazyDslKt$itemsIndexed$6 = null;
        }
        $this$itemsIndexed_u24default.items(length, lazyDslKt$itemsIndexed$6, new LazyDslKt$itemsIndexed$7(contentType, items), ComposableLambdaKt.composableLambdaInstance(1600639390, true, new LazyDslKt$itemsIndexed$8(itemContent, items)));
    }

    public static final <T> void itemsIndexed(LazyListScope $this$itemsIndexed, T[] items, Function2<? super Integer, ? super T, ? extends Object> function2, Function2<? super Integer, ? super T, ? extends Object> contentType, Function5<? super LazyItemScope, ? super Integer, ? super T, ? super Composer, ? super Integer, Unit> itemContent) {
        LazyDslKt$itemsIndexed$6 lazyDslKt$itemsIndexed$6;
        Intrinsics.checkNotNullParameter($this$itemsIndexed, "<this>");
        Intrinsics.checkNotNullParameter(items, "items");
        Intrinsics.checkNotNullParameter(contentType, "contentType");
        Intrinsics.checkNotNullParameter(itemContent, "itemContent");
        int length = items.length;
        if (function2 != null) {
            lazyDslKt$itemsIndexed$6 = new LazyDslKt$itemsIndexed$6(function2, items);
        } else {
            lazyDslKt$itemsIndexed$6 = null;
        }
        $this$itemsIndexed.items(length, lazyDslKt$itemsIndexed$6, new LazyDslKt$itemsIndexed$7(contentType, items), ComposableLambdaKt.composableLambdaInstance(1600639390, true, new LazyDslKt$itemsIndexed$8(itemContent, items)));
    }

    public static /* synthetic */ void itemsIndexed$default(LazyListScope $this$itemsIndexed_u24default, Object[] items, Function2 key, Function5 itemContent, int i, Object obj) {
        LazyDslKt$itemsIndexed$6 lazyDslKt$itemsIndexed$6;
        if ((i & 2) != 0) {
            key = null;
        }
        Intrinsics.checkNotNullParameter($this$itemsIndexed_u24default, "<this>");
        Intrinsics.checkNotNullParameter(items, "items");
        Intrinsics.checkNotNullParameter(itemContent, "itemContent");
        int length = items.length;
        if (key != null) {
            lazyDslKt$itemsIndexed$6 = new LazyDslKt$itemsIndexed$6(key, items);
        } else {
            lazyDslKt$itemsIndexed$6 = null;
        }
        $this$itemsIndexed_u24default.items(length, lazyDslKt$itemsIndexed$6, new LazyDslKt$itemsIndexed$$inlined$itemsIndexed$default$2(items), ComposableLambdaKt.composableLambdaInstance(1600639390, true, new LazyDslKt$itemsIndexed$8(itemContent, items)));
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Use the non deprecated overload")
    public static final /* synthetic */ <T> void itemsIndexed(LazyListScope $this$itemsIndexed, T[] items, Function2<? super Integer, ? super T, ? extends Object> function2, Function5<? super LazyItemScope, ? super Integer, ? super T, ? super Composer, ? super Integer, Unit> itemContent) {
        LazyDslKt$itemsIndexed$6 lazyDslKt$itemsIndexed$6;
        Intrinsics.checkNotNullParameter($this$itemsIndexed, "<this>");
        Intrinsics.checkNotNullParameter(items, "items");
        Intrinsics.checkNotNullParameter(itemContent, "itemContent");
        int length = items.length;
        if (function2 != null) {
            lazyDslKt$itemsIndexed$6 = new LazyDslKt$itemsIndexed$6(function2, items);
        } else {
            lazyDslKt$itemsIndexed$6 = null;
        }
        $this$itemsIndexed.items(length, lazyDslKt$itemsIndexed$6, new LazyDslKt$itemsIndexed$$inlined$itemsIndexed$default$2(items), ComposableLambdaKt.composableLambdaInstance(1600639390, true, new LazyDslKt$itemsIndexed$8(itemContent, items)));
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x01c9  */
    /* JADX WARN: Removed duplicated region for block: B:101:0x01b6  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x01a7  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0298  */
    /* JADX WARN: Removed duplicated region for block: B:54:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x022d  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x028e  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x01a2  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x01ad  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x01ba  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x01cd  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x01d3  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x01e5  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x01f0  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0200  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0213  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x01fc  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void LazyRow(androidx.compose.ui.Modifier r27, androidx.compose.foundation.lazy.LazyListState r28, androidx.compose.foundation.layout.PaddingValues r29, boolean r30, androidx.compose.foundation.layout.Arrangement.Horizontal r31, androidx.compose.ui.Alignment.Vertical r32, androidx.compose.foundation.gestures.FlingBehavior r33, boolean r34, final kotlin.jvm.functions.Function1<? super androidx.compose.foundation.lazy.LazyListScope, kotlin.Unit> r35, androidx.compose.runtime.Composer r36, final int r37, final int r38) {
        /*
            Method dump skipped, instructions count: 698
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.lazy.LazyDslKt.LazyRow(androidx.compose.ui.Modifier, androidx.compose.foundation.lazy.LazyListState, androidx.compose.foundation.layout.PaddingValues, boolean, androidx.compose.foundation.layout.Arrangement$Horizontal, androidx.compose.ui.Alignment$Vertical, androidx.compose.foundation.gestures.FlingBehavior, boolean, kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x01ca  */
    /* JADX WARN: Removed duplicated region for block: B:101:0x01b7  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x01a8  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0299  */
    /* JADX WARN: Removed duplicated region for block: B:54:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x022e  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x028f  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x01a3  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x01ae  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x01bb  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x01ce  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x01d4  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x01e6  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x01f1  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0201  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0214  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x01fd  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void LazyColumn(androidx.compose.ui.Modifier r27, androidx.compose.foundation.lazy.LazyListState r28, androidx.compose.foundation.layout.PaddingValues r29, boolean r30, androidx.compose.foundation.layout.Arrangement.Vertical r31, androidx.compose.ui.Alignment.Horizontal r32, androidx.compose.foundation.gestures.FlingBehavior r33, boolean r34, final kotlin.jvm.functions.Function1<? super androidx.compose.foundation.lazy.LazyListScope, kotlin.Unit> r35, androidx.compose.runtime.Composer r36, final int r37, final int r38) {
        /*
            Method dump skipped, instructions count: 699
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.lazy.LazyDslKt.LazyColumn(androidx.compose.ui.Modifier, androidx.compose.foundation.lazy.LazyListState, androidx.compose.foundation.layout.PaddingValues, boolean, androidx.compose.foundation.layout.Arrangement$Vertical, androidx.compose.ui.Alignment$Horizontal, androidx.compose.foundation.gestures.FlingBehavior, boolean, kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int, int):void");
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Use the non deprecated overload")
    public static final /* synthetic */ void LazyColumn(Modifier modifier, LazyListState state, PaddingValues contentPadding, boolean reverseLayout, Arrangement.Vertical verticalArrangement, Alignment.Horizontal horizontalAlignment, FlingBehavior flingBehavior, final Function1 content, Composer $composer, final int $changed, final int i) {
        LazyListState lazyListState;
        PaddingValues contentPadding2;
        boolean reverseLayout2;
        Arrangement.Vertical verticalArrangement2;
        Alignment.Horizontal horizontalAlignment2;
        LazyListState state2;
        FlingBehavior flingBehavior2;
        Modifier modifier2;
        int $dirty;
        LazyListState state3;
        PaddingValues contentPadding3;
        boolean reverseLayout3;
        Alignment.Horizontal horizontalAlignment3;
        Arrangement.Vertical verticalArrangement3;
        int i2;
        int i3;
        int i4;
        Intrinsics.checkNotNullParameter(content, "content");
        Composer $composer2 = $composer.startRestartGroup(-563353797);
        ComposerKt.sourceInformation($composer2, "C(LazyColumn)P(4,6,1,5,7,3,2)375@17968L23,381@18322L15,384@18385L350:LazyDsl.kt#428nma");
        int $dirty2 = $changed;
        int i5 = i & 1;
        if (i5 != 0) {
            $dirty2 |= 6;
        } else if (($changed & 14) == 0) {
            $dirty2 |= $composer2.changed(modifier) ? 4 : 2;
        }
        if (($changed & 112) == 0) {
            if ((i & 2) == 0) {
                lazyListState = state;
                if ($composer2.changed(lazyListState)) {
                    i4 = 32;
                    $dirty2 |= i4;
                }
            } else {
                lazyListState = state;
            }
            i4 = 16;
            $dirty2 |= i4;
        } else {
            lazyListState = state;
        }
        int i6 = i & 4;
        if (i6 != 0) {
            $dirty2 |= 384;
            contentPadding2 = contentPadding;
        } else if (($changed & 896) == 0) {
            contentPadding2 = contentPadding;
            $dirty2 |= $composer2.changed(contentPadding2) ? 256 : 128;
        } else {
            contentPadding2 = contentPadding;
        }
        int i7 = i & 8;
        if (i7 != 0) {
            $dirty2 |= 3072;
            reverseLayout2 = reverseLayout;
        } else if (($changed & 7168) == 0) {
            reverseLayout2 = reverseLayout;
            $dirty2 |= $composer2.changed(reverseLayout2) ? 2048 : 1024;
        } else {
            reverseLayout2 = reverseLayout;
        }
        if (($changed & 57344) == 0) {
            if ((i & 16) == 0) {
                verticalArrangement2 = verticalArrangement;
                if ($composer2.changed(verticalArrangement2)) {
                    i3 = 16384;
                    $dirty2 |= i3;
                }
            } else {
                verticalArrangement2 = verticalArrangement;
            }
            i3 = 8192;
            $dirty2 |= i3;
        } else {
            verticalArrangement2 = verticalArrangement;
        }
        int i8 = i & 32;
        if (i8 != 0) {
            $dirty2 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            horizontalAlignment2 = horizontalAlignment;
        } else if (($changed & 458752) == 0) {
            horizontalAlignment2 = horizontalAlignment;
            $dirty2 |= $composer2.changed(horizontalAlignment2) ? 131072 : 65536;
        } else {
            horizontalAlignment2 = horizontalAlignment;
        }
        if (($changed & 3670016) == 0) {
            if ((i & 64) == 0 && $composer2.changed(flingBehavior)) {
                i2 = 1048576;
                $dirty2 |= i2;
            }
            i2 = 524288;
            $dirty2 |= i2;
        }
        if ((i & 128) != 0) {
            $dirty2 |= 12582912;
        } else if ((29360128 & $changed) == 0) {
            $dirty2 |= $composer2.changedInstance(content) ? 8388608 : 4194304;
        }
        if ((23967451 & $dirty2) == 4793490 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            modifier2 = modifier;
            flingBehavior2 = flingBehavior;
            state3 = lazyListState;
            contentPadding3 = contentPadding2;
            reverseLayout3 = reverseLayout2;
            horizontalAlignment3 = horizontalAlignment2;
            verticalArrangement3 = verticalArrangement2;
        } else {
            $composer2.startDefaults();
            if (($changed & 1) == 0 || $composer2.getDefaultsInvalid()) {
                Modifier.Companion modifier3 = i5 != 0 ? Modifier.INSTANCE : modifier;
                if ((i & 2) != 0) {
                    state2 = LazyListStateKt.rememberLazyListState(0, 0, $composer2, 0, 3);
                    $dirty2 &= -113;
                } else {
                    state2 = lazyListState;
                }
                if (i6 != 0) {
                    contentPadding2 = PaddingKt.m477PaddingValues0680j_4(Dp.m5218constructorimpl(0));
                }
                if (i7 != 0) {
                    reverseLayout2 = false;
                }
                if ((i & 16) != 0) {
                    Arrangement arrangement = Arrangement.INSTANCE;
                    $dirty2 &= -57345;
                    verticalArrangement2 = !reverseLayout2 ? arrangement.getTop() : arrangement.getBottom();
                }
                if (i8 != 0) {
                    horizontalAlignment2 = Alignment.INSTANCE.getStart();
                }
                if ((i & 64) != 0) {
                    modifier2 = modifier3;
                    $dirty = $dirty2 & (-3670017);
                    state3 = state2;
                    flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior($composer2, 6);
                    contentPadding3 = contentPadding2;
                    reverseLayout3 = reverseLayout2;
                    horizontalAlignment3 = horizontalAlignment2;
                    verticalArrangement3 = verticalArrangement2;
                } else {
                    flingBehavior2 = flingBehavior;
                    modifier2 = modifier3;
                    $dirty = $dirty2;
                    state3 = state2;
                    contentPadding3 = contentPadding2;
                    reverseLayout3 = reverseLayout2;
                    horizontalAlignment3 = horizontalAlignment2;
                    verticalArrangement3 = verticalArrangement2;
                }
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 2) != 0) {
                    $dirty2 &= -113;
                }
                if ((i & 16) != 0) {
                    $dirty2 &= -57345;
                }
                if ((i & 64) != 0) {
                    modifier2 = modifier;
                    flingBehavior2 = flingBehavior;
                    $dirty = $dirty2 & (-3670017);
                    state3 = lazyListState;
                    contentPadding3 = contentPadding2;
                    reverseLayout3 = reverseLayout2;
                    horizontalAlignment3 = horizontalAlignment2;
                    verticalArrangement3 = verticalArrangement2;
                } else {
                    modifier2 = modifier;
                    flingBehavior2 = flingBehavior;
                    $dirty = $dirty2;
                    state3 = lazyListState;
                    contentPadding3 = contentPadding2;
                    reverseLayout3 = reverseLayout2;
                    horizontalAlignment3 = horizontalAlignment2;
                    verticalArrangement3 = verticalArrangement2;
                }
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-563353797, $dirty, -1, "androidx.compose.foundation.lazy.LazyColumn (LazyDsl.kt:373)");
            }
            LazyColumn(modifier2, state3, contentPadding3, reverseLayout3, verticalArrangement3, horizontalAlignment3, flingBehavior2, true, content, $composer2, ($dirty & 14) | 12582912 | ($dirty & 112) | ($dirty & 896) | ($dirty & 7168) | (57344 & $dirty) | ($dirty & 458752) | ($dirty & 3670016) | (($dirty << 3) & 234881024), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        final Modifier modifier4 = modifier2;
        final LazyListState lazyListState2 = state3;
        final PaddingValues paddingValues = contentPadding3;
        final boolean z = reverseLayout3;
        final Arrangement.Vertical vertical = verticalArrangement3;
        final Alignment.Horizontal horizontal = horizontalAlignment3;
        final FlingBehavior flingBehavior3 = flingBehavior2;
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.lazy.LazyDslKt$LazyColumn$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                invoke(composer, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer, int i9) {
                LazyDslKt.LazyColumn(Modifier.this, lazyListState2, paddingValues, z, vertical, horizontal, flingBehavior3, content, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
            }
        });
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Use the non deprecated overload")
    public static final /* synthetic */ void LazyRow(Modifier modifier, LazyListState state, PaddingValues contentPadding, boolean reverseLayout, Arrangement.Horizontal horizontalArrangement, Alignment.Vertical verticalAlignment, FlingBehavior flingBehavior, final Function1 content, Composer $composer, final int $changed, final int i) {
        LazyListState lazyListState;
        PaddingValues contentPadding2;
        boolean reverseLayout2;
        Arrangement.Horizontal horizontalArrangement2;
        Alignment.Vertical verticalAlignment2;
        LazyListState state2;
        FlingBehavior flingBehavior2;
        Modifier modifier2;
        int $dirty;
        LazyListState state3;
        PaddingValues contentPadding3;
        boolean reverseLayout3;
        Alignment.Vertical verticalAlignment3;
        Arrangement.Horizontal horizontalArrangement3;
        int i2;
        int i3;
        int i4;
        Intrinsics.checkNotNullParameter(content, "content");
        Composer $composer2 = $composer.startRestartGroup(407929823);
        ComposerKt.sourceInformation($composer2, "C(LazyRow)P(4,6,1,5,3,7,2)401@18906L23,407@19257L15,410@19320L347:LazyDsl.kt#428nma");
        int $dirty2 = $changed;
        int i5 = i & 1;
        if (i5 != 0) {
            $dirty2 |= 6;
        } else if (($changed & 14) == 0) {
            $dirty2 |= $composer2.changed(modifier) ? 4 : 2;
        }
        if (($changed & 112) == 0) {
            if ((i & 2) == 0) {
                lazyListState = state;
                if ($composer2.changed(lazyListState)) {
                    i4 = 32;
                    $dirty2 |= i4;
                }
            } else {
                lazyListState = state;
            }
            i4 = 16;
            $dirty2 |= i4;
        } else {
            lazyListState = state;
        }
        int i6 = i & 4;
        if (i6 != 0) {
            $dirty2 |= 384;
            contentPadding2 = contentPadding;
        } else if (($changed & 896) == 0) {
            contentPadding2 = contentPadding;
            $dirty2 |= $composer2.changed(contentPadding2) ? 256 : 128;
        } else {
            contentPadding2 = contentPadding;
        }
        int i7 = i & 8;
        if (i7 != 0) {
            $dirty2 |= 3072;
            reverseLayout2 = reverseLayout;
        } else if (($changed & 7168) == 0) {
            reverseLayout2 = reverseLayout;
            $dirty2 |= $composer2.changed(reverseLayout2) ? 2048 : 1024;
        } else {
            reverseLayout2 = reverseLayout;
        }
        if (($changed & 57344) == 0) {
            if ((i & 16) == 0) {
                horizontalArrangement2 = horizontalArrangement;
                if ($composer2.changed(horizontalArrangement2)) {
                    i3 = 16384;
                    $dirty2 |= i3;
                }
            } else {
                horizontalArrangement2 = horizontalArrangement;
            }
            i3 = 8192;
            $dirty2 |= i3;
        } else {
            horizontalArrangement2 = horizontalArrangement;
        }
        int i8 = i & 32;
        if (i8 != 0) {
            $dirty2 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            verticalAlignment2 = verticalAlignment;
        } else if (($changed & 458752) == 0) {
            verticalAlignment2 = verticalAlignment;
            $dirty2 |= $composer2.changed(verticalAlignment2) ? 131072 : 65536;
        } else {
            verticalAlignment2 = verticalAlignment;
        }
        if (($changed & 3670016) == 0) {
            if ((i & 64) == 0 && $composer2.changed(flingBehavior)) {
                i2 = 1048576;
                $dirty2 |= i2;
            }
            i2 = 524288;
            $dirty2 |= i2;
        }
        if ((i & 128) != 0) {
            $dirty2 |= 12582912;
        } else if ((29360128 & $changed) == 0) {
            $dirty2 |= $composer2.changedInstance(content) ? 8388608 : 4194304;
        }
        if ((23967451 & $dirty2) == 4793490 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            modifier2 = modifier;
            flingBehavior2 = flingBehavior;
            state3 = lazyListState;
            contentPadding3 = contentPadding2;
            reverseLayout3 = reverseLayout2;
            verticalAlignment3 = verticalAlignment2;
            horizontalArrangement3 = horizontalArrangement2;
        } else {
            $composer2.startDefaults();
            if (($changed & 1) == 0 || $composer2.getDefaultsInvalid()) {
                Modifier.Companion modifier3 = i5 != 0 ? Modifier.INSTANCE : modifier;
                if ((i & 2) != 0) {
                    state2 = LazyListStateKt.rememberLazyListState(0, 0, $composer2, 0, 3);
                    $dirty2 &= -113;
                } else {
                    state2 = lazyListState;
                }
                if (i6 != 0) {
                    contentPadding2 = PaddingKt.m477PaddingValues0680j_4(Dp.m5218constructorimpl(0));
                }
                if (i7 != 0) {
                    reverseLayout2 = false;
                }
                if ((i & 16) != 0) {
                    Arrangement arrangement = Arrangement.INSTANCE;
                    $dirty2 &= -57345;
                    horizontalArrangement2 = !reverseLayout2 ? arrangement.getStart() : arrangement.getEnd();
                }
                if (i8 != 0) {
                    verticalAlignment2 = Alignment.INSTANCE.getTop();
                }
                if ((i & 64) != 0) {
                    modifier2 = modifier3;
                    $dirty = $dirty2 & (-3670017);
                    state3 = state2;
                    flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior($composer2, 6);
                    contentPadding3 = contentPadding2;
                    reverseLayout3 = reverseLayout2;
                    verticalAlignment3 = verticalAlignment2;
                    horizontalArrangement3 = horizontalArrangement2;
                } else {
                    flingBehavior2 = flingBehavior;
                    modifier2 = modifier3;
                    $dirty = $dirty2;
                    state3 = state2;
                    contentPadding3 = contentPadding2;
                    reverseLayout3 = reverseLayout2;
                    verticalAlignment3 = verticalAlignment2;
                    horizontalArrangement3 = horizontalArrangement2;
                }
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 2) != 0) {
                    $dirty2 &= -113;
                }
                if ((i & 16) != 0) {
                    $dirty2 &= -57345;
                }
                if ((i & 64) != 0) {
                    modifier2 = modifier;
                    flingBehavior2 = flingBehavior;
                    $dirty = $dirty2 & (-3670017);
                    state3 = lazyListState;
                    contentPadding3 = contentPadding2;
                    reverseLayout3 = reverseLayout2;
                    verticalAlignment3 = verticalAlignment2;
                    horizontalArrangement3 = horizontalArrangement2;
                } else {
                    modifier2 = modifier;
                    flingBehavior2 = flingBehavior;
                    $dirty = $dirty2;
                    state3 = lazyListState;
                    contentPadding3 = contentPadding2;
                    reverseLayout3 = reverseLayout2;
                    verticalAlignment3 = verticalAlignment2;
                    horizontalArrangement3 = horizontalArrangement2;
                }
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(407929823, $dirty, -1, "androidx.compose.foundation.lazy.LazyRow (LazyDsl.kt:399)");
            }
            LazyRow(modifier2, state3, contentPadding3, reverseLayout3, horizontalArrangement3, verticalAlignment3, flingBehavior2, true, content, $composer2, ($dirty & 14) | 12582912 | ($dirty & 112) | ($dirty & 896) | ($dirty & 7168) | (57344 & $dirty) | ($dirty & 458752) | ($dirty & 3670016) | (($dirty << 3) & 234881024), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        final Modifier modifier4 = modifier2;
        final LazyListState lazyListState2 = state3;
        final PaddingValues paddingValues = contentPadding3;
        final boolean z = reverseLayout3;
        final Arrangement.Horizontal horizontal = horizontalArrangement3;
        final Alignment.Vertical vertical = verticalAlignment3;
        final FlingBehavior flingBehavior3 = flingBehavior2;
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.lazy.LazyDslKt$LazyRow$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                invoke(composer, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer, int i9) {
                LazyDslKt.LazyRow(Modifier.this, lazyListState2, paddingValues, z, horizontal, vertical, flingBehavior3, content, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
            }
        });
    }
}
