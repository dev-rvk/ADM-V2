package androidx.compose.ui.tooling.animation;

import androidx.compose.ui.tooling.PreviewUtilsKt;
import androidx.compose.ui.tooling.data.Group;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AnimationSearch.kt */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u001e\n\u0000\u001a&\u0010\t\u001a\u0004\u0018\u0001H\n\"\u0006\b\u0000\u0010\n\u0018\u0001*\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\rH\u0082\b¢\u0006\u0002\u0010\u000e\u001a!\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\n0\u0010\"\u0006\b\u0000\u0010\n\u0018\u0001*\b\u0012\u0004\u0012\u00020\u000b0\u0011H\u0082\b\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"ANIMATED_CONTENT", "", "ANIMATED_VISIBILITY", "ANIMATE_VALUE_AS_STATE", "REMEMBER", "REMEMBER_INFINITE_TRANSITION", "REMEMBER_UPDATED_STATE", "SIZE_ANIMATION_MODIFIER", "UPDATE_TRANSITION", "findData", "T", "Landroidx/compose/ui/tooling/data/Group;", "includeGrandchildren", "", "(Landroidx/compose/ui/tooling/data/Group;Z)Ljava/lang/Object;", "findRememberedData", "", "", "ui-tooling_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class AnimationSearchKt {
    private static final String ANIMATED_CONTENT = "AnimatedContent";
    private static final String ANIMATED_VISIBILITY = "AnimatedVisibility";
    private static final String ANIMATE_VALUE_AS_STATE = "animateValueAsState";
    private static final String REMEMBER = "remember";
    private static final String REMEMBER_INFINITE_TRANSITION = "rememberInfiniteTransition";
    private static final String REMEMBER_UPDATED_STATE = "rememberUpdatedState";
    private static final String SIZE_ANIMATION_MODIFIER = "androidx.compose.animation.SizeAnimationModifier";
    private static final String UPDATE_TRANSITION = "updateTransition";

    private static final /* synthetic */ <T> List<T> findRememberedData(Collection<? extends Group> collection) {
        int $i$f$findRememberedData;
        T t;
        T t2;
        int $i$f$findRememberedData2 = 0;
        Collection<? extends Group> $this$mapNotNull$iv = collection;
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv$iv : $this$mapNotNull$iv) {
            Group it = (Group) element$iv$iv$iv;
            Iterable $this$firstOrNull$iv = it.getData();
            Iterator<T> it2 = $this$firstOrNull$iv.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    t2 = null;
                    break;
                }
                T next = it2.next();
                Intrinsics.reifiedOperationMarker(3, "T");
                if (next instanceof Object) {
                    t2 = next;
                    break;
                }
            }
            Intrinsics.reifiedOperationMarker(2, "T");
            if (t2 != null) {
                destination$iv$iv.add(t2);
            }
        }
        List selfData = (List) destination$iv$iv;
        Collection<? extends Group> $this$mapNotNull$iv2 = collection;
        Collection destination$iv$iv2 = new ArrayList();
        for (Object element$iv$iv$iv2 : $this$mapNotNull$iv2) {
            Group it3 = (Group) element$iv$iv$iv2;
            Group it4 = PreviewUtilsKt.firstOrNull(it3, AnimationSearchKt$findRememberedData$rememberCalls$1$1.INSTANCE);
            if (it4 != null) {
                destination$iv$iv2.add(it4);
            }
        }
        Iterable rememberCalls = (List) destination$iv$iv2;
        List list = selfData;
        Iterable $this$mapNotNull$iv3 = rememberCalls;
        Collection destination$iv$iv3 = new ArrayList();
        for (Object element$iv$iv$iv3 : $this$mapNotNull$iv3) {
            Group it5 = (Group) element$iv$iv$iv3;
            Iterable $this$firstOrNull$iv2 = it5.getData();
            Iterator<T> it6 = $this$firstOrNull$iv2.iterator();
            while (true) {
                if (!it6.hasNext()) {
                    $i$f$findRememberedData = $i$f$findRememberedData2;
                    t = null;
                    break;
                }
                t = it6.next();
                $i$f$findRememberedData = $i$f$findRememberedData2;
                Intrinsics.reifiedOperationMarker(3, "T");
                if (t instanceof Object) {
                    break;
                }
                $i$f$findRememberedData2 = $i$f$findRememberedData;
            }
            Intrinsics.reifiedOperationMarker(2, "T");
            if (t != null) {
                destination$iv$iv3.add(t);
            }
            $i$f$findRememberedData2 = $i$f$findRememberedData;
        }
        return CollectionsKt.plus((Collection) list, destination$iv$iv3);
    }

    static /* synthetic */ Object findData$default(Group $this$findData_u24default, boolean includeGrandchildren, int i, Object obj) {
        Object element$iv;
        if ((i & 1) != 0) {
            includeGrandchildren = false;
        }
        Collection<Object> data = $this$findData_u24default.getData();
        Collection it = $this$findData_u24default.getChildren();
        if (includeGrandchildren) {
            Collection $this$flatMap$iv = it;
            Collection destination$iv$iv = new ArrayList();
            for (Object element$iv$iv : $this$flatMap$iv) {
                Group child = (Group) element$iv$iv;
                Iterable list$iv$iv = child.getChildren();
                CollectionsKt.addAll(destination$iv$iv, list$iv$iv);
            }
            it = CollectionsKt.plus(it, destination$iv$iv);
        }
        Collection $this$flatMap$iv2 = it;
        Collection destination$iv$iv2 = new ArrayList();
        for (Object element$iv$iv2 : $this$flatMap$iv2) {
            Iterable list$iv$iv2 = ((Group) element$iv$iv2).getData();
            CollectionsKt.addAll(destination$iv$iv2, list$iv$iv2);
        }
        Iterable dataToSearch = CollectionsKt.plus((Collection) data, destination$iv$iv2);
        Iterable $this$firstOrNull$iv = dataToSearch;
        Iterator it2 = $this$firstOrNull$iv.iterator();
        while (true) {
            if (it2.hasNext()) {
                element$iv = it2.next();
                Intrinsics.reifiedOperationMarker(3, "T");
                if (element$iv instanceof Object) {
                    break;
                }
            } else {
                element$iv = null;
                break;
            }
        }
        Intrinsics.reifiedOperationMarker(2, "T");
        return element$iv;
    }

    private static final /* synthetic */ <T> T findData(Group $this$findData, boolean includeGrandchildren) {
        T t;
        Collection<Object> data = $this$findData.getData();
        Collection it = $this$findData.getChildren();
        if (includeGrandchildren) {
            Collection $this$flatMap$iv = it;
            Collection destination$iv$iv = new ArrayList();
            for (Object element$iv$iv : $this$flatMap$iv) {
                Group child = (Group) element$iv$iv;
                Iterable list$iv$iv = child.getChildren();
                CollectionsKt.addAll(destination$iv$iv, list$iv$iv);
            }
            it = CollectionsKt.plus(it, destination$iv$iv);
        }
        Collection $this$flatMap$iv2 = it;
        Collection destination$iv$iv2 = new ArrayList();
        for (Object element$iv$iv2 : $this$flatMap$iv2) {
            Iterable list$iv$iv2 = ((Group) element$iv$iv2).getData();
            CollectionsKt.addAll(destination$iv$iv2, list$iv$iv2);
        }
        Iterable dataToSearch = CollectionsKt.plus((Collection) data, destination$iv$iv2);
        Iterable $this$firstOrNull$iv = dataToSearch;
        Iterator<T> it2 = $this$firstOrNull$iv.iterator();
        while (true) {
            if (it2.hasNext()) {
                t = it2.next();
                Intrinsics.reifiedOperationMarker(3, "T");
                if (t instanceof Object) {
                    break;
                }
            } else {
                t = null;
                break;
            }
        }
        Intrinsics.reifiedOperationMarker(2, "T");
        return t;
    }
}
