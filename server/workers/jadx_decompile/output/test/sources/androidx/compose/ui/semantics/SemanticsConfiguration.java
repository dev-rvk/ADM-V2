package androidx.compose.ui.semantics;

import androidx.compose.ui.platform.JvmActuals_jvmKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

/* compiled from: SemanticsConfiguration.kt */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0002\u0010&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010%\n\u0000\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010(\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u00012\u001a\u0012\u0016\u0012\u0014\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00030\u0002B\u0005¢\u0006\u0002\u0010\u0006J\u0015\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0000H\u0000¢\u0006\u0002\b\u0013J\u001d\u0010\u0014\u001a\u00020\b\"\u0004\b\u0000\u0010\u00152\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u0002H\u00150\u0004H\u0086\u0002J\u0006\u0010\u0017\u001a\u00020\u0000J\u0013\u0010\u0018\u001a\u00020\b2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0005H\u0096\u0002J\"\u0010\u001a\u001a\u0002H\u0015\"\u0004\b\u0000\u0010\u00152\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u0002H\u00150\u0004H\u0086\u0002¢\u0006\u0002\u0010\u001bJ-\u0010\u001c\u001a\u0002H\u0015\"\u0004\b\u0000\u0010\u00152\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u0002H\u00150\u00042\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u0002H\u00150\u001e¢\u0006\u0002\u0010\u001fJ1\u0010 \u001a\u0004\u0018\u0001H\u0015\"\u0004\b\u0000\u0010\u00152\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u0002H\u00150\u00042\u000e\u0010\u001d\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001H\u00150\u001e¢\u0006\u0002\u0010\u001fJ\b\u0010!\u001a\u00020\"H\u0016J!\u0010#\u001a\u001a\u0012\u0016\u0012\u0014\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00030$H\u0096\u0002J\u0015\u0010%\u001a\u00020\u00112\u0006\u0010&\u001a\u00020\u0000H\u0000¢\u0006\u0002\b'J*\u0010(\u001a\u00020\u0011\"\u0004\b\u0000\u0010\u00152\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u0002H\u00150\u00042\u0006\u0010)\u001a\u0002H\u0015H\u0096\u0002¢\u0006\u0002\u0010*J\b\u0010+\u001a\u00020,H\u0016R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\t\"\u0004\b\r\u0010\u000bR \u0010\u000e\u001a\u0014\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u000fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006-"}, d2 = {"Landroidx/compose/ui/semantics/SemanticsConfiguration;", "Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;", "", "", "Landroidx/compose/ui/semantics/SemanticsPropertyKey;", "", "()V", "isClearingSemantics", "", "()Z", "setClearingSemantics", "(Z)V", "isMergingSemanticsOfDescendants", "setMergingSemanticsOfDescendants", "props", "", "collapsePeer", "", "peer", "collapsePeer$ui_release", "contains", "T", "key", "copy", "equals", "other", "get", "(Landroidx/compose/ui/semantics/SemanticsPropertyKey;)Ljava/lang/Object;", "getOrElse", "defaultValue", "Lkotlin/Function0;", "(Landroidx/compose/ui/semantics/SemanticsPropertyKey;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "getOrElseNullable", "hashCode", "", "iterator", "", "mergeChild", "child", "mergeChild$ui_release", "set", "value", "(Landroidx/compose/ui/semantics/SemanticsPropertyKey;Ljava/lang/Object;)V", "toString", "", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class SemanticsConfiguration implements SemanticsPropertyReceiver, Iterable<Map.Entry<? extends SemanticsPropertyKey<?>, ? extends Object>>, KMappedMarker {
    public static final int $stable = 8;
    private boolean isClearingSemantics;
    private boolean isMergingSemanticsOfDescendants;
    private final Map<SemanticsPropertyKey<?>, Object> props = new LinkedHashMap();

    public final <T> T get(SemanticsPropertyKey<T> key) {
        Intrinsics.checkNotNullParameter(key, "key");
        T t = (T) this.props.get(key);
        if (t != null) {
            return t;
        }
        throw new IllegalStateException("Key not present: " + key + " - consider getOrElse or getOrNull");
    }

    public final <T> T getOrElse(SemanticsPropertyKey<T> key, Function0<? extends T> defaultValue) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        T t = (T) this.props.get(key);
        return t == null ? defaultValue.invoke() : t;
    }

    public final <T> T getOrElseNullable(SemanticsPropertyKey<T> key, Function0<? extends T> defaultValue) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        T t = (T) this.props.get(key);
        return t == null ? defaultValue.invoke() : t;
    }

    @Override // java.lang.Iterable
    public Iterator<Map.Entry<? extends SemanticsPropertyKey<?>, ? extends Object>> iterator() {
        return this.props.entrySet().iterator();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.compose.ui.semantics.SemanticsPropertyReceiver
    public <T> void set(SemanticsPropertyKey<T> key, T value) {
        Intrinsics.checkNotNullParameter(key, "key");
        if ((value instanceof AccessibilityAction) && contains(key)) {
            Object obj = this.props.get(key);
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type androidx.compose.ui.semantics.AccessibilityAction<*>");
            AccessibilityAction prev = (AccessibilityAction) obj;
            Map<SemanticsPropertyKey<?>, Object> map = this.props;
            String label = ((AccessibilityAction) value).getLabel();
            if (label == null) {
                label = prev.getLabel();
            }
            Function action = ((AccessibilityAction) value).getAction();
            if (action == null) {
                action = prev.getAction();
            }
            map.put(key, new AccessibilityAction(label, action));
            return;
        }
        this.props.put(key, value);
    }

    public final <T> boolean contains(SemanticsPropertyKey<T> key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return this.props.containsKey(key);
    }

    /* renamed from: isMergingSemanticsOfDescendants, reason: from getter */
    public final boolean getIsMergingSemanticsOfDescendants() {
        return this.isMergingSemanticsOfDescendants;
    }

    public final void setMergingSemanticsOfDescendants(boolean z) {
        this.isMergingSemanticsOfDescendants = z;
    }

    /* renamed from: isClearingSemantics, reason: from getter */
    public final boolean getIsClearingSemantics() {
        return this.isClearingSemantics;
    }

    public final void setClearingSemantics(boolean z) {
        this.isClearingSemantics = z;
    }

    public final void mergeChild$ui_release(SemanticsConfiguration child) {
        Intrinsics.checkNotNullParameter(child, "child");
        for (Map.Entry<SemanticsPropertyKey<?>, Object> entry : child.props.entrySet()) {
            SemanticsPropertyKey key = entry.getKey();
            Object nextValue = entry.getValue();
            Object existingValue = this.props.get(key);
            Intrinsics.checkNotNull(key, "null cannot be cast to non-null type androidx.compose.ui.semantics.SemanticsPropertyKey<kotlin.Any?>");
            Object mergeResult = key.merge(existingValue, nextValue);
            if (mergeResult != null) {
                this.props.put(key, mergeResult);
            }
        }
    }

    public final void collapsePeer$ui_release(SemanticsConfiguration peer) {
        Intrinsics.checkNotNullParameter(peer, "peer");
        if (peer.isMergingSemanticsOfDescendants) {
            this.isMergingSemanticsOfDescendants = true;
        }
        if (peer.isClearingSemantics) {
            this.isClearingSemantics = true;
        }
        for (Map.Entry<SemanticsPropertyKey<?>, Object> entry : peer.props.entrySet()) {
            SemanticsPropertyKey key = entry.getKey();
            Object nextValue = entry.getValue();
            if (!this.props.containsKey(key)) {
                this.props.put(key, nextValue);
            } else if (nextValue instanceof AccessibilityAction) {
                Object obj = this.props.get(key);
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type androidx.compose.ui.semantics.AccessibilityAction<*>");
                AccessibilityAction value = (AccessibilityAction) obj;
                Map<SemanticsPropertyKey<?>, Object> map = this.props;
                String label = value.getLabel();
                if (label == null) {
                    label = ((AccessibilityAction) nextValue).getLabel();
                }
                Function action = value.getAction();
                if (action == null) {
                    action = ((AccessibilityAction) nextValue).getAction();
                }
                map.put(key, new AccessibilityAction(label, action));
            }
        }
    }

    public final SemanticsConfiguration copy() {
        SemanticsConfiguration copy = new SemanticsConfiguration();
        copy.isMergingSemanticsOfDescendants = this.isMergingSemanticsOfDescendants;
        copy.isClearingSemantics = this.isClearingSemantics;
        copy.props.putAll(this.props);
        return copy;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof SemanticsConfiguration) && Intrinsics.areEqual(this.props, ((SemanticsConfiguration) other).props) && this.isMergingSemanticsOfDescendants == ((SemanticsConfiguration) other).isMergingSemanticsOfDescendants && this.isClearingSemantics == ((SemanticsConfiguration) other).isClearingSemantics;
    }

    public int hashCode() {
        int result = this.props.hashCode();
        return (((result * 31) + Boolean.hashCode(this.isMergingSemanticsOfDescendants)) * 31) + Boolean.hashCode(this.isClearingSemantics);
    }

    public String toString() {
        StringBuilder propsString = new StringBuilder();
        String nextSeparator = "";
        if (this.isMergingSemanticsOfDescendants) {
            propsString.append("");
            propsString.append("mergeDescendants=true");
            nextSeparator = ", ";
        }
        if (this.isClearingSemantics) {
            propsString.append(nextSeparator);
            propsString.append("isClearingSemantics=true");
            nextSeparator = ", ";
        }
        for (Map.Entry<SemanticsPropertyKey<?>, Object> entry : this.props.entrySet()) {
            SemanticsPropertyKey key = entry.getKey();
            Object value = entry.getValue();
            propsString.append(nextSeparator);
            propsString.append(key.getName());
            propsString.append(" : ");
            propsString.append(value);
            nextSeparator = ", ";
        }
        return JvmActuals_jvmKt.simpleIdentityToString(this, null) + "{ " + ((Object) propsString) + " }";
    }
}
