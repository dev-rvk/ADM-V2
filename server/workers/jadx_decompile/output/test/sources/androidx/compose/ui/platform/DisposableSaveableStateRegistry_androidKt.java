package androidx.compose.ui.platform;

import android.os.Binder;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Size;
import android.util.SizeF;
import android.util.SparseArray;
import android.view.View;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.saveable.SaveableStateRegistry;
import androidx.compose.runtime.saveable.SaveableStateRegistryKt;
import androidx.compose.runtime.snapshots.SnapshotMutableState;
import androidx.compose.ui.R;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateRegistryOwner;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DisposableSaveableStateRegistry.android.kt */
@Metadata(d1 = {"\u0000D\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010 \n\u0002\b\u0002\u001a\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0000\u001a\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\nH\u0000\u001a\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0003H\u0002\u001a \u0010\u0011\u001a\u00020\u0012*\u0016\u0012\u0004\u0012\u00020\f\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00140\u0013H\u0002\u001a\"\u0010\u0015\u001a\u0018\u0012\u0004\u0012\u00020\f\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0014\u0018\u00010\u0013*\u00020\u0012H\u0002\"\u001e\u0010\u0000\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0004¨\u0006\u0016"}, d2 = {"AcceptableClasses", "", "Ljava/lang/Class;", "", "[Ljava/lang/Class;", "DisposableSaveableStateRegistry", "Landroidx/compose/ui/platform/DisposableSaveableStateRegistry;", "view", "Landroid/view/View;", "owner", "Landroidx/savedstate/SavedStateRegistryOwner;", "id", "", "savedStateRegistryOwner", "canBeSavedToBundle", "", "value", "toBundle", "Landroid/os/Bundle;", "", "", "toMap", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class DisposableSaveableStateRegistry_androidKt {
    private static final Class<? extends Object>[] AcceptableClasses = {Serializable.class, Parcelable.class, String.class, SparseArray.class, Binder.class, Size.class, SizeF.class};

    public static final DisposableSaveableStateRegistry DisposableSaveableStateRegistry(View view, SavedStateRegistryOwner owner) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(owner, "owner");
        Object parent = view.getParent();
        Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.View");
        View composeView = (View) parent;
        Object tag = composeView.getTag(R.id.compose_view_saveable_id_tag);
        String idFromTag = tag instanceof String ? (String) tag : null;
        String id = idFromTag == null ? String.valueOf(composeView.getId()) : idFromTag;
        return DisposableSaveableStateRegistry(id, owner);
    }

    public static final DisposableSaveableStateRegistry DisposableSaveableStateRegistry(String id, SavedStateRegistryOwner savedStateRegistryOwner) {
        final boolean registered;
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(savedStateRegistryOwner, "savedStateRegistryOwner");
        final String key = SaveableStateRegistry.class.getSimpleName() + ':' + id;
        final SavedStateRegistry androidxRegistry = savedStateRegistryOwner.getSavedStateRegistry();
        Bundle bundle = androidxRegistry.consumeRestoredStateForKey(key);
        Map restored = bundle != null ? toMap(bundle) : null;
        final SaveableStateRegistry saveableStateRegistry = SaveableStateRegistryKt.SaveableStateRegistry(restored, new Function1<Object, Boolean>() { // from class: androidx.compose.ui.platform.DisposableSaveableStateRegistry_androidKt$DisposableSaveableStateRegistry$saveableStateRegistry$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(Object it) {
                boolean canBeSavedToBundle;
                Intrinsics.checkNotNullParameter(it, "it");
                canBeSavedToBundle = DisposableSaveableStateRegistry_androidKt.canBeSavedToBundle(it);
                return Boolean.valueOf(canBeSavedToBundle);
            }
        });
        try {
            androidxRegistry.registerSavedStateProvider(key, new SavedStateRegistry.SavedStateProvider() { // from class: androidx.compose.ui.platform.DisposableSaveableStateRegistry_androidKt$DisposableSaveableStateRegistry$registered$1
                @Override // androidx.savedstate.SavedStateRegistry.SavedStateProvider
                public final Bundle saveState() {
                    Bundle bundle2;
                    bundle2 = DisposableSaveableStateRegistry_androidKt.toBundle(SaveableStateRegistry.this.performSave());
                    return bundle2;
                }
            });
            registered = true;
        } catch (IllegalArgumentException e) {
            registered = false;
        }
        return new DisposableSaveableStateRegistry(saveableStateRegistry, new Function0<Unit>() { // from class: androidx.compose.ui.platform.DisposableSaveableStateRegistry_androidKt$DisposableSaveableStateRegistry$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                if (registered) {
                    androidxRegistry.unregisterSavedStateProvider(key);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean canBeSavedToBundle(Object value) {
        if (value instanceof SnapshotMutableState) {
            if (((SnapshotMutableState) value).getPolicy() != SnapshotStateKt.neverEqualPolicy() && ((SnapshotMutableState) value).getPolicy() != SnapshotStateKt.structuralEqualityPolicy() && ((SnapshotMutableState) value).getPolicy() != SnapshotStateKt.referentialEqualityPolicy()) {
                return false;
            }
            Object stateValue = ((SnapshotMutableState) value).getValue();
            if (stateValue == null) {
                return true;
            }
            return canBeSavedToBundle(stateValue);
        }
        if ((value instanceof Function) && (value instanceof Serializable)) {
            return false;
        }
        for (Class cl : AcceptableClasses) {
            if (cl.isInstance(value)) {
                return true;
            }
        }
        return false;
    }

    private static final Map<String, List<Object>> toMap(Bundle $this$toMap) {
        Map map = new LinkedHashMap();
        Iterable keySet = $this$toMap.keySet();
        Intrinsics.checkNotNullExpressionValue(keySet, "this.keySet()");
        Iterable $this$forEach$iv = keySet;
        for (Object element$iv : $this$forEach$iv) {
            String key = (String) element$iv;
            ArrayList list = $this$toMap.getParcelableArrayList(key);
            Intrinsics.checkNotNull(list, "null cannot be cast to non-null type java.util.ArrayList<kotlin.Any?>{ kotlin.collections.TypeAliasesKt.ArrayList<kotlin.Any?> }");
            Intrinsics.checkNotNullExpressionValue(key, "key");
            map.put(key, list);
        }
        return map;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Bundle toBundle(Map<String, ? extends List<? extends Object>> map) {
        Bundle bundle = new Bundle();
        for (Map.Entry element$iv : map.entrySet()) {
            String key = element$iv.getKey();
            List<? extends Object> list = element$iv.getValue();
            ArrayList arrayList = list instanceof ArrayList ? (ArrayList) list : new ArrayList(list);
            bundle.putParcelableArrayList(key, arrayList);
        }
        return bundle;
    }
}
