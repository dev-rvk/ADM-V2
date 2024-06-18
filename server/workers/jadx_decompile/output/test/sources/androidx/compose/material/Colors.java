package androidx.compose.material;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.Color;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: Colors.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b1\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001Bp\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0010ø\u0001\u0000¢\u0006\u0002\u0010\u0011J\u0095\u0001\u0010>\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u0010ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b?\u0010@J\b\u0010A\u001a\u00020BH\u0016R4\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00038F@@X\u0086\u008e\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R4\u0010\t\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00038F@@X\u0086\u008e\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0012\n\u0004\b\u001b\u0010\u0018\u001a\u0004\b\u0019\u0010\u0014\"\u0004\b\u001a\u0010\u0016R+\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00108F@@X\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u001f\u0010\u0018\u001a\u0004\b\u000f\u0010\u001c\"\u0004\b\u001d\u0010\u001eR4\u0010\f\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00038F@@X\u0086\u008e\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0012\n\u0004\b\"\u0010\u0018\u001a\u0004\b \u0010\u0014\"\u0004\b!\u0010\u0016R4\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00038F@@X\u0086\u008e\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0012\n\u0004\b%\u0010\u0018\u001a\u0004\b#\u0010\u0014\"\u0004\b$\u0010\u0016R4\u0010\n\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00038F@@X\u0086\u008e\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0012\n\u0004\b(\u0010\u0018\u001a\u0004\b&\u0010\u0014\"\u0004\b'\u0010\u0016R4\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00038F@@X\u0086\u008e\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0012\n\u0004\b+\u0010\u0018\u001a\u0004\b)\u0010\u0014\"\u0004\b*\u0010\u0016R4\u0010\r\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00038F@@X\u0086\u008e\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0012\n\u0004\b.\u0010\u0018\u001a\u0004\b,\u0010\u0014\"\u0004\b-\u0010\u0016R4\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00038F@@X\u0086\u008e\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0012\n\u0004\b1\u0010\u0018\u001a\u0004\b/\u0010\u0014\"\u0004\b0\u0010\u0016R4\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00038F@@X\u0086\u008e\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0012\n\u0004\b4\u0010\u0018\u001a\u0004\b2\u0010\u0014\"\u0004\b3\u0010\u0016R4\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00038F@@X\u0086\u008e\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0012\n\u0004\b7\u0010\u0018\u001a\u0004\b5\u0010\u0014\"\u0004\b6\u0010\u0016R4\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00038F@@X\u0086\u008e\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0012\n\u0004\b:\u0010\u0018\u001a\u0004\b8\u0010\u0014\"\u0004\b9\u0010\u0016R4\u0010\b\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00038F@@X\u0086\u008e\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0012\n\u0004\b=\u0010\u0018\u001a\u0004\b;\u0010\u0014\"\u0004\b<\u0010\u0016\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006C"}, d2 = {"Landroidx/compose/material/Colors;", "", "primary", "Landroidx/compose/ui/graphics/Color;", "primaryVariant", "secondary", "secondaryVariant", "background", "surface", "error", "onPrimary", "onSecondary", "onBackground", "onSurface", "onError", "isLight", "", "(JJJJJJJJJJJJZLkotlin/jvm/internal/DefaultConstructorMarker;)V", "<set-?>", "getBackground-0d7_KjU", "()J", "setBackground-8_81llA$material_release", "(J)V", "background$delegate", "Landroidx/compose/runtime/MutableState;", "getError-0d7_KjU", "setError-8_81llA$material_release", "error$delegate", "()Z", "setLight$material_release", "(Z)V", "isLight$delegate", "getOnBackground-0d7_KjU", "setOnBackground-8_81llA$material_release", "onBackground$delegate", "getOnError-0d7_KjU", "setOnError-8_81llA$material_release", "onError$delegate", "getOnPrimary-0d7_KjU", "setOnPrimary-8_81llA$material_release", "onPrimary$delegate", "getOnSecondary-0d7_KjU", "setOnSecondary-8_81llA$material_release", "onSecondary$delegate", "getOnSurface-0d7_KjU", "setOnSurface-8_81llA$material_release", "onSurface$delegate", "getPrimary-0d7_KjU", "setPrimary-8_81llA$material_release", "primary$delegate", "getPrimaryVariant-0d7_KjU", "setPrimaryVariant-8_81llA$material_release", "primaryVariant$delegate", "getSecondary-0d7_KjU", "setSecondary-8_81llA$material_release", "secondary$delegate", "getSecondaryVariant-0d7_KjU", "setSecondaryVariant-8_81llA$material_release", "secondaryVariant$delegate", "getSurface-0d7_KjU", "setSurface-8_81llA$material_release", "surface$delegate", "copy", "copy-pvPzIIM", "(JJJJJJJJJJJJZ)Landroidx/compose/material/Colors;", "toString", "", "material_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class Colors {
    public static final int $stable = 0;

    /* renamed from: background$delegate, reason: from kotlin metadata */
    private final MutableState background;

    /* renamed from: error$delegate, reason: from kotlin metadata */
    private final MutableState error;

    /* renamed from: isLight$delegate, reason: from kotlin metadata */
    private final MutableState isLight;

    /* renamed from: onBackground$delegate, reason: from kotlin metadata */
    private final MutableState onBackground;

    /* renamed from: onError$delegate, reason: from kotlin metadata */
    private final MutableState onError;

    /* renamed from: onPrimary$delegate, reason: from kotlin metadata */
    private final MutableState onPrimary;

    /* renamed from: onSecondary$delegate, reason: from kotlin metadata */
    private final MutableState onSecondary;

    /* renamed from: onSurface$delegate, reason: from kotlin metadata */
    private final MutableState onSurface;

    /* renamed from: primary$delegate, reason: from kotlin metadata */
    private final MutableState primary;

    /* renamed from: primaryVariant$delegate, reason: from kotlin metadata */
    private final MutableState primaryVariant;

    /* renamed from: secondary$delegate, reason: from kotlin metadata */
    private final MutableState secondary;

    /* renamed from: secondaryVariant$delegate, reason: from kotlin metadata */
    private final MutableState secondaryVariant;

    /* renamed from: surface$delegate, reason: from kotlin metadata */
    private final MutableState surface;

    public /* synthetic */ Colors(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, boolean z, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, j3, j4, j5, j6, j7, j8, j9, j10, j11, j12, z);
    }

    private Colors(long primary, long primaryVariant, long secondary, long secondaryVariant, long background, long surface, long error, long onPrimary, long onSecondary, long onBackground, long onSurface, long onError, boolean isLight) {
        this.primary = SnapshotStateKt.mutableStateOf(Color.m2939boximpl(primary), SnapshotStateKt.structuralEqualityPolicy());
        this.primaryVariant = SnapshotStateKt.mutableStateOf(Color.m2939boximpl(primaryVariant), SnapshotStateKt.structuralEqualityPolicy());
        this.secondary = SnapshotStateKt.mutableStateOf(Color.m2939boximpl(secondary), SnapshotStateKt.structuralEqualityPolicy());
        this.secondaryVariant = SnapshotStateKt.mutableStateOf(Color.m2939boximpl(secondaryVariant), SnapshotStateKt.structuralEqualityPolicy());
        this.background = SnapshotStateKt.mutableStateOf(Color.m2939boximpl(background), SnapshotStateKt.structuralEqualityPolicy());
        this.surface = SnapshotStateKt.mutableStateOf(Color.m2939boximpl(surface), SnapshotStateKt.structuralEqualityPolicy());
        this.error = SnapshotStateKt.mutableStateOf(Color.m2939boximpl(error), SnapshotStateKt.structuralEqualityPolicy());
        this.onPrimary = SnapshotStateKt.mutableStateOf(Color.m2939boximpl(onPrimary), SnapshotStateKt.structuralEqualityPolicy());
        this.onSecondary = SnapshotStateKt.mutableStateOf(Color.m2939boximpl(onSecondary), SnapshotStateKt.structuralEqualityPolicy());
        this.onBackground = SnapshotStateKt.mutableStateOf(Color.m2939boximpl(onBackground), SnapshotStateKt.structuralEqualityPolicy());
        this.onSurface = SnapshotStateKt.mutableStateOf(Color.m2939boximpl(onSurface), SnapshotStateKt.structuralEqualityPolicy());
        this.onError = SnapshotStateKt.mutableStateOf(Color.m2939boximpl(onError), SnapshotStateKt.structuralEqualityPolicy());
        this.isLight = SnapshotStateKt.mutableStateOf(Boolean.valueOf(isLight), SnapshotStateKt.structuralEqualityPolicy());
    }

    /* renamed from: getPrimary-0d7_KjU, reason: not valid java name */
    public final long m1036getPrimary0d7_KjU() {
        State $this$getValue$iv = this.primary;
        return ((Color) $this$getValue$iv.getValue()).m2959unboximpl();
    }

    /* renamed from: setPrimary-8_81llA$material_release, reason: not valid java name */
    public final void m1048setPrimary8_81llA$material_release(long j) {
        MutableState $this$setValue$iv = this.primary;
        $this$setValue$iv.setValue(Color.m2939boximpl(j));
    }

    /* renamed from: getPrimaryVariant-0d7_KjU, reason: not valid java name */
    public final long m1037getPrimaryVariant0d7_KjU() {
        State $this$getValue$iv = this.primaryVariant;
        return ((Color) $this$getValue$iv.getValue()).m2959unboximpl();
    }

    /* renamed from: setPrimaryVariant-8_81llA$material_release, reason: not valid java name */
    public final void m1049setPrimaryVariant8_81llA$material_release(long j) {
        MutableState $this$setValue$iv = this.primaryVariant;
        $this$setValue$iv.setValue(Color.m2939boximpl(j));
    }

    /* renamed from: getSecondary-0d7_KjU, reason: not valid java name */
    public final long m1038getSecondary0d7_KjU() {
        State $this$getValue$iv = this.secondary;
        return ((Color) $this$getValue$iv.getValue()).m2959unboximpl();
    }

    /* renamed from: setSecondary-8_81llA$material_release, reason: not valid java name */
    public final void m1050setSecondary8_81llA$material_release(long j) {
        MutableState $this$setValue$iv = this.secondary;
        $this$setValue$iv.setValue(Color.m2939boximpl(j));
    }

    /* renamed from: getSecondaryVariant-0d7_KjU, reason: not valid java name */
    public final long m1039getSecondaryVariant0d7_KjU() {
        State $this$getValue$iv = this.secondaryVariant;
        return ((Color) $this$getValue$iv.getValue()).m2959unboximpl();
    }

    /* renamed from: setSecondaryVariant-8_81llA$material_release, reason: not valid java name */
    public final void m1051setSecondaryVariant8_81llA$material_release(long j) {
        MutableState $this$setValue$iv = this.secondaryVariant;
        $this$setValue$iv.setValue(Color.m2939boximpl(j));
    }

    /* renamed from: getBackground-0d7_KjU, reason: not valid java name */
    public final long m1029getBackground0d7_KjU() {
        State $this$getValue$iv = this.background;
        return ((Color) $this$getValue$iv.getValue()).m2959unboximpl();
    }

    /* renamed from: setBackground-8_81llA$material_release, reason: not valid java name */
    public final void m1041setBackground8_81llA$material_release(long j) {
        MutableState $this$setValue$iv = this.background;
        $this$setValue$iv.setValue(Color.m2939boximpl(j));
    }

    /* renamed from: getSurface-0d7_KjU, reason: not valid java name */
    public final long m1040getSurface0d7_KjU() {
        State $this$getValue$iv = this.surface;
        return ((Color) $this$getValue$iv.getValue()).m2959unboximpl();
    }

    /* renamed from: setSurface-8_81llA$material_release, reason: not valid java name */
    public final void m1052setSurface8_81llA$material_release(long j) {
        MutableState $this$setValue$iv = this.surface;
        $this$setValue$iv.setValue(Color.m2939boximpl(j));
    }

    /* renamed from: getError-0d7_KjU, reason: not valid java name */
    public final long m1030getError0d7_KjU() {
        State $this$getValue$iv = this.error;
        return ((Color) $this$getValue$iv.getValue()).m2959unboximpl();
    }

    /* renamed from: setError-8_81llA$material_release, reason: not valid java name */
    public final void m1042setError8_81llA$material_release(long j) {
        MutableState $this$setValue$iv = this.error;
        $this$setValue$iv.setValue(Color.m2939boximpl(j));
    }

    /* renamed from: getOnPrimary-0d7_KjU, reason: not valid java name */
    public final long m1033getOnPrimary0d7_KjU() {
        State $this$getValue$iv = this.onPrimary;
        return ((Color) $this$getValue$iv.getValue()).m2959unboximpl();
    }

    /* renamed from: setOnPrimary-8_81llA$material_release, reason: not valid java name */
    public final void m1045setOnPrimary8_81llA$material_release(long j) {
        MutableState $this$setValue$iv = this.onPrimary;
        $this$setValue$iv.setValue(Color.m2939boximpl(j));
    }

    /* renamed from: getOnSecondary-0d7_KjU, reason: not valid java name */
    public final long m1034getOnSecondary0d7_KjU() {
        State $this$getValue$iv = this.onSecondary;
        return ((Color) $this$getValue$iv.getValue()).m2959unboximpl();
    }

    /* renamed from: setOnSecondary-8_81llA$material_release, reason: not valid java name */
    public final void m1046setOnSecondary8_81llA$material_release(long j) {
        MutableState $this$setValue$iv = this.onSecondary;
        $this$setValue$iv.setValue(Color.m2939boximpl(j));
    }

    /* renamed from: getOnBackground-0d7_KjU, reason: not valid java name */
    public final long m1031getOnBackground0d7_KjU() {
        State $this$getValue$iv = this.onBackground;
        return ((Color) $this$getValue$iv.getValue()).m2959unboximpl();
    }

    /* renamed from: setOnBackground-8_81llA$material_release, reason: not valid java name */
    public final void m1043setOnBackground8_81llA$material_release(long j) {
        MutableState $this$setValue$iv = this.onBackground;
        $this$setValue$iv.setValue(Color.m2939boximpl(j));
    }

    /* renamed from: getOnSurface-0d7_KjU, reason: not valid java name */
    public final long m1035getOnSurface0d7_KjU() {
        State $this$getValue$iv = this.onSurface;
        return ((Color) $this$getValue$iv.getValue()).m2959unboximpl();
    }

    /* renamed from: setOnSurface-8_81llA$material_release, reason: not valid java name */
    public final void m1047setOnSurface8_81llA$material_release(long j) {
        MutableState $this$setValue$iv = this.onSurface;
        $this$setValue$iv.setValue(Color.m2939boximpl(j));
    }

    /* renamed from: getOnError-0d7_KjU, reason: not valid java name */
    public final long m1032getOnError0d7_KjU() {
        State $this$getValue$iv = this.onError;
        return ((Color) $this$getValue$iv.getValue()).m2959unboximpl();
    }

    /* renamed from: setOnError-8_81llA$material_release, reason: not valid java name */
    public final void m1044setOnError8_81llA$material_release(long j) {
        MutableState $this$setValue$iv = this.onError;
        $this$setValue$iv.setValue(Color.m2939boximpl(j));
    }

    public final boolean isLight() {
        State $this$getValue$iv = this.isLight;
        return ((Boolean) $this$getValue$iv.getValue()).booleanValue();
    }

    public final void setLight$material_release(boolean z) {
        MutableState $this$setValue$iv = this.isLight;
        $this$setValue$iv.setValue(Boolean.valueOf(z));
    }

    /* renamed from: copy-pvPzIIM, reason: not valid java name */
    public final Colors m1028copypvPzIIM(long primary, long primaryVariant, long secondary, long secondaryVariant, long background, long surface, long error, long onPrimary, long onSecondary, long onBackground, long onSurface, long onError, boolean isLight) {
        return new Colors(primary, primaryVariant, secondary, secondaryVariant, background, surface, error, onPrimary, onSecondary, onBackground, onSurface, onError, isLight, null);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Colors(primary=").append((Object) Color.m2957toStringimpl(m1036getPrimary0d7_KjU())).append(", primaryVariant=").append((Object) Color.m2957toStringimpl(m1037getPrimaryVariant0d7_KjU())).append(", secondary=").append((Object) Color.m2957toStringimpl(m1038getSecondary0d7_KjU())).append(", secondaryVariant=").append((Object) Color.m2957toStringimpl(m1039getSecondaryVariant0d7_KjU())).append(", background=").append((Object) Color.m2957toStringimpl(m1029getBackground0d7_KjU())).append(", surface=").append((Object) Color.m2957toStringimpl(m1040getSurface0d7_KjU())).append(", error=").append((Object) Color.m2957toStringimpl(m1030getError0d7_KjU())).append(", onPrimary=").append((Object) Color.m2957toStringimpl(m1033getOnPrimary0d7_KjU())).append(", onSecondary=").append((Object) Color.m2957toStringimpl(m1034getOnSecondary0d7_KjU())).append(", onBackground=").append((Object) Color.m2957toStringimpl(m1031getOnBackground0d7_KjU())).append(", onSurface=").append((Object) Color.m2957toStringimpl(m1035getOnSurface0d7_KjU())).append(", onError=");
        sb.append((Object) Color.m2957toStringimpl(m1032getOnError0d7_KjU())).append(", isLight=").append(isLight()).append(')');
        return sb.toString();
    }
}
