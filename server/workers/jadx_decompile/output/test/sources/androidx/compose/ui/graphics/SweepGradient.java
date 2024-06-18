package androidx.compose.ui.graphics;

import android.graphics.Shader;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Brush.kt */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B2\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0005ø\u0001\u0000¢\u0006\u0002\u0010\tJ!\u0010\u000b\u001a\u00060\fj\u0002`\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0096\u0002J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0019H\u0016R\u0019\u0010\u0002\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\nR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004ø\u0001\u0000¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u001a"}, d2 = {"Landroidx/compose/ui/graphics/SweepGradient;", "Landroidx/compose/ui/graphics/ShaderBrush;", "center", "Landroidx/compose/ui/geometry/Offset;", "colors", "", "Landroidx/compose/ui/graphics/Color;", "stops", "", "(JLjava/util/List;Ljava/util/List;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "J", "createShader", "Landroid/graphics/Shader;", "Landroidx/compose/ui/graphics/Shader;", "size", "Landroidx/compose/ui/geometry/Size;", "createShader-uvyYCjk", "(J)Landroid/graphics/Shader;", "equals", "", "other", "", "hashCode", "", "toString", "", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class SweepGradient extends ShaderBrush {
    private final long center;
    private final List<Color> colors;
    private final List<Float> stops;

    public /* synthetic */ SweepGradient(long j, List list, List list2, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, list, list2);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ SweepGradient(long r7, java.util.List r9, java.util.List r10, int r11, kotlin.jvm.internal.DefaultConstructorMarker r12) {
        /*
            r6 = this;
            r11 = r11 & 4
            if (r11 == 0) goto L7
            r10 = 0
            r4 = r10
            goto L8
        L7:
            r4 = r10
        L8:
            r5 = 0
            r0 = r6
            r1 = r7
            r3 = r9
            r0.<init>(r1, r3, r4, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.graphics.SweepGradient.<init>(long, java.util.List, java.util.List, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    private SweepGradient(long center, List<Color> colors, List<Float> list) {
        Intrinsics.checkNotNullParameter(colors, "colors");
        this.center = center;
        this.colors = colors;
        this.stops = list;
    }

    @Override // androidx.compose.ui.graphics.ShaderBrush
    /* renamed from: createShader-uvyYCjk */
    public Shader mo2918createShaderuvyYCjk(long size) {
        long Offset;
        if (OffsetKt.m2731isUnspecifiedk4lQ0M(this.center)) {
            Offset = SizeKt.m2789getCenteruvyYCjk(size);
        } else {
            Offset = OffsetKt.Offset((Offset.m2710getXimpl(this.center) > Float.POSITIVE_INFINITY ? 1 : (Offset.m2710getXimpl(this.center) == Float.POSITIVE_INFINITY ? 0 : -1)) == 0 ? Size.m2779getWidthimpl(size) : Offset.m2710getXimpl(this.center), Offset.m2711getYimpl(this.center) == Float.POSITIVE_INFINITY ? Size.m2776getHeightimpl(size) : Offset.m2711getYimpl(this.center));
        }
        return ShaderKt.m3261SweepGradientShader9KIMszo(Offset, this.colors, this.stops);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof SweepGradient) && Offset.m2707equalsimpl0(this.center, ((SweepGradient) other).center) && Intrinsics.areEqual(this.colors, ((SweepGradient) other).colors) && Intrinsics.areEqual(this.stops, ((SweepGradient) other).stops);
    }

    public int hashCode() {
        int result = Offset.m2712hashCodeimpl(this.center);
        int result2 = ((result * 31) + this.colors.hashCode()) * 31;
        List<Float> list = this.stops;
        return result2 + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        String centerValue = OffsetKt.m2729isSpecifiedk4lQ0M(this.center) ? "center=" + ((Object) Offset.m2718toStringimpl(this.center)) + ", " : "";
        return "SweepGradient(" + centerValue + "colors=" + this.colors + ", stops=" + this.stops + ')';
    }
}
