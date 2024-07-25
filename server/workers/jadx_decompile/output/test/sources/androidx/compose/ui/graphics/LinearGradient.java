package androidx.compose.ui.graphics;

import android.graphics.Shader;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Size;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Brush.kt */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001BD\b\u0000\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010\n\u001a\u00020\u000bø\u0001\u0000¢\u0006\u0002\u0010\fJ!\u0010\u0013\u001a\u00060\u0014j\u0002`\u00152\u0006\u0010\u0016\u001a\u00020\u000fH\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0018J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0096\u0002J\b\u0010\u001d\u001a\u00020\u001eH\u0016J\b\u0010\u001f\u001a\u00020 H\u0016R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004ø\u0001\u0000¢\u0006\u0002\n\u0000R\u0019\u0010\t\u001a\u00020\bX\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\rR\u001d\u0010\u000e\u001a\u00020\u000f8VX\u0096\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0007\u001a\u00020\bX\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\rR\u0016\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\n\u001a\u00020\u000bX\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0012\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006!"}, d2 = {"Landroidx/compose/ui/graphics/LinearGradient;", "Landroidx/compose/ui/graphics/ShaderBrush;", "colors", "", "Landroidx/compose/ui/graphics/Color;", "stops", "", "start", "Landroidx/compose/ui/geometry/Offset;", "end", "tileMode", "Landroidx/compose/ui/graphics/TileMode;", "(Ljava/util/List;Ljava/util/List;JJILkotlin/jvm/internal/DefaultConstructorMarker;)V", "J", "intrinsicSize", "Landroidx/compose/ui/geometry/Size;", "getIntrinsicSize-NH-jbRc", "()J", "I", "createShader", "Landroid/graphics/Shader;", "Landroidx/compose/ui/graphics/Shader;", "size", "createShader-uvyYCjk", "(J)Landroid/graphics/Shader;", "equals", "", "other", "", "hashCode", "", "toString", "", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class LinearGradient extends ShaderBrush {
    private final List<Color> colors;
    private final long end;
    private final long start;
    private final List<Float> stops;
    private final int tileMode;

    public /* synthetic */ LinearGradient(List list, List list2, long j, long j2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, list2, j, j2, i);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ LinearGradient(java.util.List r11, java.util.List r12, long r13, long r15, int r17, int r18, kotlin.jvm.internal.DefaultConstructorMarker r19) {
        /*
            r10 = this;
            r0 = r18 & 2
            if (r0 == 0) goto L7
            r0 = 0
            r3 = r0
            goto L8
        L7:
            r3 = r12
        L8:
            r0 = r18 & 16
            if (r0 == 0) goto L14
            androidx.compose.ui.graphics.TileMode$Companion r0 = androidx.compose.ui.graphics.TileMode.INSTANCE
            int r0 = r0.m3315getClamp3opZhB0()
            r8 = r0
            goto L16
        L14:
            r8 = r17
        L16:
            r9 = 0
            r1 = r10
            r2 = r11
            r4 = r13
            r6 = r15
            r1.<init>(r2, r3, r4, r6, r8, r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.graphics.LinearGradient.<init>(java.util.List, java.util.List, long, long, int, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    private LinearGradient(List<Color> colors, List<Float> list, long start, long end, int tileMode) {
        Intrinsics.checkNotNullParameter(colors, "colors");
        this.colors = colors;
        this.stops = list;
        this.start = start;
        this.end = end;
        this.tileMode = tileMode;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x005c  */
    @Override // androidx.compose.ui.graphics.Brush
    /* renamed from: getIntrinsicSize-NH-jbRc */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public long getIntrinsicSize() {
        /*
            r6 = this;
            long r0 = r6.start
            float r0 = androidx.compose.ui.geometry.Offset.m2710getXimpl(r0)
            boolean r1 = java.lang.Float.isInfinite(r0)
            r2 = 1
            r3 = 0
            if (r1 != 0) goto L16
            boolean r0 = java.lang.Float.isNaN(r0)
            if (r0 != 0) goto L16
            r0 = r2
            goto L17
        L16:
            r0 = r3
        L17:
            r1 = 2143289344(0x7fc00000, float:NaN)
            if (r0 == 0) goto L44
            long r4 = r6.end
            float r0 = androidx.compose.ui.geometry.Offset.m2710getXimpl(r4)
            boolean r4 = java.lang.Float.isInfinite(r0)
            if (r4 != 0) goto L2f
            boolean r0 = java.lang.Float.isNaN(r0)
            if (r0 != 0) goto L2f
            r0 = r2
            goto L30
        L2f:
            r0 = r3
        L30:
            if (r0 == 0) goto L44
            long r4 = r6.start
            float r0 = androidx.compose.ui.geometry.Offset.m2710getXimpl(r4)
            long r4 = r6.end
            float r4 = androidx.compose.ui.geometry.Offset.m2710getXimpl(r4)
            float r0 = r0 - r4
            float r0 = java.lang.Math.abs(r0)
            goto L45
        L44:
            r0 = r1
        L45:
            long r4 = r6.start
            float r4 = androidx.compose.ui.geometry.Offset.m2711getYimpl(r4)
            boolean r5 = java.lang.Float.isInfinite(r4)
            if (r5 != 0) goto L59
            boolean r4 = java.lang.Float.isNaN(r4)
            if (r4 != 0) goto L59
            r4 = r2
            goto L5a
        L59:
            r4 = r3
        L5a:
            if (r4 == 0) goto L83
            long r4 = r6.end
            float r4 = androidx.compose.ui.geometry.Offset.m2711getYimpl(r4)
            boolean r5 = java.lang.Float.isInfinite(r4)
            if (r5 != 0) goto L6f
            boolean r4 = java.lang.Float.isNaN(r4)
            if (r4 != 0) goto L6f
            goto L70
        L6f:
            r2 = r3
        L70:
            if (r2 == 0) goto L83
            long r1 = r6.start
            float r1 = androidx.compose.ui.geometry.Offset.m2711getYimpl(r1)
            long r2 = r6.end
            float r2 = androidx.compose.ui.geometry.Offset.m2711getYimpl(r2)
            float r1 = r1 - r2
            float r1 = java.lang.Math.abs(r1)
        L83:
            long r0 = androidx.compose.ui.geometry.SizeKt.Size(r0, r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.graphics.LinearGradient.getIntrinsicSize():long");
    }

    @Override // androidx.compose.ui.graphics.ShaderBrush
    /* renamed from: createShader-uvyYCjk */
    public Shader mo2918createShaderuvyYCjk(long size) {
        float startX = (Offset.m2710getXimpl(this.start) > Float.POSITIVE_INFINITY ? 1 : (Offset.m2710getXimpl(this.start) == Float.POSITIVE_INFINITY ? 0 : -1)) == 0 ? Size.m2779getWidthimpl(size) : Offset.m2710getXimpl(this.start);
        float startY = (Offset.m2711getYimpl(this.start) > Float.POSITIVE_INFINITY ? 1 : (Offset.m2711getYimpl(this.start) == Float.POSITIVE_INFINITY ? 0 : -1)) == 0 ? Size.m2776getHeightimpl(size) : Offset.m2711getYimpl(this.start);
        float endX = (Offset.m2710getXimpl(this.end) > Float.POSITIVE_INFINITY ? 1 : (Offset.m2710getXimpl(this.end) == Float.POSITIVE_INFINITY ? 0 : -1)) == 0 ? Size.m2779getWidthimpl(size) : Offset.m2710getXimpl(this.end);
        float endY = Offset.m2711getYimpl(this.end) == Float.POSITIVE_INFINITY ? Size.m2776getHeightimpl(size) : Offset.m2711getYimpl(this.end);
        return ShaderKt.m3257LinearGradientShaderVjE6UOU(OffsetKt.Offset(startX, startY), OffsetKt.Offset(endX, endY), this.colors, this.stops, this.tileMode);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof LinearGradient) && Intrinsics.areEqual(this.colors, ((LinearGradient) other).colors) && Intrinsics.areEqual(this.stops, ((LinearGradient) other).stops) && Offset.m2707equalsimpl0(this.start, ((LinearGradient) other).start) && Offset.m2707equalsimpl0(this.end, ((LinearGradient) other).end) && TileMode.m3311equalsimpl0(this.tileMode, ((LinearGradient) other).tileMode);
    }

    public int hashCode() {
        int result = this.colors.hashCode();
        int i = result * 31;
        List<Float> list = this.stops;
        int result2 = i + (list != null ? list.hashCode() : 0);
        return (((((result2 * 31) + Offset.m2712hashCodeimpl(this.start)) * 31) + Offset.m2712hashCodeimpl(this.end)) * 31) + TileMode.m3312hashCodeimpl(this.tileMode);
    }

    public String toString() {
        String startValue = OffsetKt.m2727isFinitek4lQ0M(this.start) ? "start=" + ((Object) Offset.m2718toStringimpl(this.start)) + ", " : "";
        String endValue = OffsetKt.m2727isFinitek4lQ0M(this.end) ? "end=" + ((Object) Offset.m2718toStringimpl(this.end)) + ", " : "";
        return "LinearGradient(colors=" + this.colors + ", stops=" + this.stops + ", " + startValue + endValue + "tileMode=" + ((Object) TileMode.m3313toStringimpl(this.tileMode)) + ')';
    }
}
