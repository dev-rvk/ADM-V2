package androidx.compose.ui.text.font;

import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FontWeight.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u0000 \u000f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000fB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0011\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0000H\u0096\u0002J\u0013\u0010\t\u001a\u00020\n2\b\u0010\b\u001a\u0004\u0018\u00010\u000bH\u0096\u0002J\b\u0010\f\u001a\u00020\u0003H\u0016J\b\u0010\r\u001a\u00020\u000eH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Landroidx/compose/ui/text/font/FontWeight;", "", "weight", "", "(I)V", "getWeight", "()I", "compareTo", "other", "equals", "", "", "hashCode", "toString", "", "Companion", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class FontWeight implements Comparable<FontWeight> {
    public static final int $stable = 0;
    private final int weight;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final FontWeight W100 = new FontWeight(100);
    private static final FontWeight W200 = new FontWeight(200);
    private static final FontWeight W300 = new FontWeight(300);
    private static final FontWeight W400 = new FontWeight(400);
    private static final FontWeight W500 = new FontWeight(500);
    private static final FontWeight W600 = new FontWeight(600);
    private static final FontWeight W700 = new FontWeight(700);
    private static final FontWeight W800 = new FontWeight(800);
    private static final FontWeight W900 = new FontWeight(900);
    private static final FontWeight Thin = W100;
    private static final FontWeight ExtraLight = W200;
    private static final FontWeight Light = W300;
    private static final FontWeight Normal = W400;
    private static final FontWeight Medium = W500;
    private static final FontWeight SemiBold = W600;
    private static final FontWeight Bold = W700;
    private static final FontWeight ExtraBold = W800;
    private static final FontWeight Black = W900;
    private static final List<FontWeight> values = CollectionsKt.listOf((Object[]) new FontWeight[]{W100, W200, W300, W400, W500, W600, W700, W800, W900});

    public FontWeight(int weight) {
        this.weight = weight;
        int i = this.weight;
        boolean z = false;
        if (1 <= i && i < 1001) {
            z = true;
        }
        if (z) {
        } else {
            throw new IllegalArgumentException(("Font weight can be in range [1, 1000]. Current value: " + this.weight).toString());
        }
    }

    public final int getWeight() {
        return this.weight;
    }

    /* compiled from: FontWeight.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b7\n\u0002\u0010 \n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\b\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\t\u0010\u0002\u001a\u0004\b\n\u0010\u0007R\u001c\u0010\u000b\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\f\u0010\u0002\u001a\u0004\b\r\u0010\u0007R\u001c\u0010\u000e\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000f\u0010\u0002\u001a\u0004\b\u0010\u0010\u0007R\u001c\u0010\u0011\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0012\u0010\u0002\u001a\u0004\b\u0013\u0010\u0007R\u001c\u0010\u0014\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0015\u0010\u0002\u001a\u0004\b\u0016\u0010\u0007R\u001c\u0010\u0017\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0018\u0010\u0002\u001a\u0004\b\u0019\u0010\u0007R\u001c\u0010\u001a\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001b\u0010\u0002\u001a\u0004\b\u001c\u0010\u0007R\u001c\u0010\u001d\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001e\u0010\u0002\u001a\u0004\b\u001f\u0010\u0007R\u001c\u0010 \u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b!\u0010\u0002\u001a\u0004\b\"\u0010\u0007R\u001c\u0010#\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b$\u0010\u0002\u001a\u0004\b%\u0010\u0007R\u001c\u0010&\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b'\u0010\u0002\u001a\u0004\b(\u0010\u0007R\u001c\u0010)\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b*\u0010\u0002\u001a\u0004\b+\u0010\u0007R\u001c\u0010,\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b-\u0010\u0002\u001a\u0004\b.\u0010\u0007R\u001c\u0010/\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b0\u0010\u0002\u001a\u0004\b1\u0010\u0007R\u001c\u00102\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b3\u0010\u0002\u001a\u0004\b4\u0010\u0007R\u001c\u00105\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b6\u0010\u0002\u001a\u0004\b7\u0010\u0007R\u001c\u00108\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b9\u0010\u0002\u001a\u0004\b:\u0010\u0007R\u001a\u0010;\u001a\b\u0012\u0004\u0012\u00020\u00040<X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b=\u0010>¨\u0006?"}, d2 = {"Landroidx/compose/ui/text/font/FontWeight$Companion;", "", "()V", "Black", "Landroidx/compose/ui/text/font/FontWeight;", "getBlack$annotations", "getBlack", "()Landroidx/compose/ui/text/font/FontWeight;", "Bold", "getBold$annotations", "getBold", "ExtraBold", "getExtraBold$annotations", "getExtraBold", "ExtraLight", "getExtraLight$annotations", "getExtraLight", "Light", "getLight$annotations", "getLight", "Medium", "getMedium$annotations", "getMedium", "Normal", "getNormal$annotations", "getNormal", "SemiBold", "getSemiBold$annotations", "getSemiBold", "Thin", "getThin$annotations", "getThin", "W100", "getW100$annotations", "getW100", "W200", "getW200$annotations", "getW200", "W300", "getW300$annotations", "getW300", "W400", "getW400$annotations", "getW400", "W500", "getW500$annotations", "getW500", "W600", "getW600$annotations", "getW600", "W700", "getW700$annotations", "getW700", "W800", "getW800$annotations", "getW800", "W900", "getW900$annotations", "getW900", "values", "", "getValues$ui_text_release", "()Ljava/util/List;", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void getBlack$annotations() {
        }

        public static /* synthetic */ void getBold$annotations() {
        }

        public static /* synthetic */ void getExtraBold$annotations() {
        }

        public static /* synthetic */ void getExtraLight$annotations() {
        }

        public static /* synthetic */ void getLight$annotations() {
        }

        public static /* synthetic */ void getMedium$annotations() {
        }

        public static /* synthetic */ void getNormal$annotations() {
        }

        public static /* synthetic */ void getSemiBold$annotations() {
        }

        public static /* synthetic */ void getThin$annotations() {
        }

        public static /* synthetic */ void getW100$annotations() {
        }

        public static /* synthetic */ void getW200$annotations() {
        }

        public static /* synthetic */ void getW300$annotations() {
        }

        public static /* synthetic */ void getW400$annotations() {
        }

        public static /* synthetic */ void getW500$annotations() {
        }

        public static /* synthetic */ void getW600$annotations() {
        }

        public static /* synthetic */ void getW700$annotations() {
        }

        public static /* synthetic */ void getW800$annotations() {
        }

        public static /* synthetic */ void getW900$annotations() {
        }

        private Companion() {
        }

        public final FontWeight getW100() {
            return FontWeight.W100;
        }

        public final FontWeight getW200() {
            return FontWeight.W200;
        }

        public final FontWeight getW300() {
            return FontWeight.W300;
        }

        public final FontWeight getW400() {
            return FontWeight.W400;
        }

        public final FontWeight getW500() {
            return FontWeight.W500;
        }

        public final FontWeight getW600() {
            return FontWeight.W600;
        }

        public final FontWeight getW700() {
            return FontWeight.W700;
        }

        public final FontWeight getW800() {
            return FontWeight.W800;
        }

        public final FontWeight getW900() {
            return FontWeight.W900;
        }

        public final FontWeight getThin() {
            return FontWeight.Thin;
        }

        public final FontWeight getExtraLight() {
            return FontWeight.ExtraLight;
        }

        public final FontWeight getLight() {
            return FontWeight.Light;
        }

        public final FontWeight getNormal() {
            return FontWeight.Normal;
        }

        public final FontWeight getMedium() {
            return FontWeight.Medium;
        }

        public final FontWeight getSemiBold() {
            return FontWeight.SemiBold;
        }

        public final FontWeight getBold() {
            return FontWeight.Bold;
        }

        public final FontWeight getExtraBold() {
            return FontWeight.ExtraBold;
        }

        public final FontWeight getBlack() {
            return FontWeight.Black;
        }

        public final List<FontWeight> getValues$ui_text_release() {
            return FontWeight.values;
        }
    }

    @Override // java.lang.Comparable
    public int compareTo(FontWeight other) {
        Intrinsics.checkNotNullParameter(other, "other");
        return Intrinsics.compare(this.weight, other.weight);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof FontWeight) && this.weight == ((FontWeight) other).weight;
    }

    public int hashCode() {
        return this.weight;
    }

    public String toString() {
        return "FontWeight(weight=" + this.weight + ')';
    }
}
