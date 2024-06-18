package androidx.compose.ui.graphics.vector;

import androidx.autofill.HintConstants;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Vector.kt */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u000e\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u00102\u001a\u00020\bH\u0002J\b\u00103\u001a\u00020\u001cH\u0016J\f\u00104\u001a\u00020\b*\u00020\u0007H\u0016J\u001c\u00104\u001a\u00020\b*\u00020\u00072\u0006\u00105\u001a\u00020)2\b\u00106\u001a\u0004\u0018\u00010\u000bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001f\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0002\b\tX\u0082\u0004¢\u0006\u0002\n\u0000R/\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\u000b8@@@X\u0080\u008e\u0002¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R \u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\b0\u0014X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001b\u001a\u00020\u001c8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u0019\u0010\"\u001a\u00020#X\u0082\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010$R\u0011\u0010%\u001a\u00020&¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R$\u0010*\u001a\u00020)2\u0006\u0010\u001b\u001a\u00020)@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R$\u0010/\u001a\u00020)2\u0006\u0010\u001b\u001a\u00020)@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010,\"\u0004\b1\u0010.\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u00067"}, d2 = {"Landroidx/compose/ui/graphics/vector/VectorComponent;", "Landroidx/compose/ui/graphics/vector/VNode;", "()V", "cacheDrawScope", "Landroidx/compose/ui/graphics/vector/DrawCache;", "drawVectorBlock", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "", "Lkotlin/ExtensionFunctionType;", "<set-?>", "Landroidx/compose/ui/graphics/ColorFilter;", "intrinsicColorFilter", "getIntrinsicColorFilter$ui_release", "()Landroidx/compose/ui/graphics/ColorFilter;", "setIntrinsicColorFilter$ui_release", "(Landroidx/compose/ui/graphics/ColorFilter;)V", "intrinsicColorFilter$delegate", "Landroidx/compose/runtime/MutableState;", "invalidateCallback", "Lkotlin/Function0;", "getInvalidateCallback$ui_release", "()Lkotlin/jvm/functions/Function0;", "setInvalidateCallback$ui_release", "(Lkotlin/jvm/functions/Function0;)V", "isDirty", "", "value", "", HintConstants.AUTOFILL_HINT_NAME, "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "previousDrawSize", "Landroidx/compose/ui/geometry/Size;", "J", "root", "Landroidx/compose/ui/graphics/vector/GroupComponent;", "getRoot", "()Landroidx/compose/ui/graphics/vector/GroupComponent;", "", "viewportHeight", "getViewportHeight", "()F", "setViewportHeight", "(F)V", "viewportWidth", "getViewportWidth", "setViewportWidth", "doInvalidate", "toString", "draw", "alpha", "colorFilter", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class VectorComponent extends VNode {
    private final DrawCache cacheDrawScope;
    private final Function1<DrawScope, Unit> drawVectorBlock;

    /* renamed from: intrinsicColorFilter$delegate, reason: from kotlin metadata */
    private final MutableState intrinsicColorFilter;
    private Function0<Unit> invalidateCallback;
    private boolean isDirty;
    private long previousDrawSize;
    private final GroupComponent root;
    private float viewportHeight;
    private float viewportWidth;

    public VectorComponent() {
        super(null);
        MutableState mutableStateOf$default;
        GroupComponent $this$root_u24lambda_u240 = new GroupComponent();
        $this$root_u24lambda_u240.setPivotX(0.0f);
        $this$root_u24lambda_u240.setPivotY(0.0f);
        $this$root_u24lambda_u240.setInvalidateListener$ui_release(new Function0<Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComponent$root$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
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
                VectorComponent.this.doInvalidate();
            }
        });
        this.root = $this$root_u24lambda_u240;
        this.isDirty = true;
        this.cacheDrawScope = new DrawCache();
        this.invalidateCallback = new Function0<Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComponent$invalidateCallback$1
            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
            }
        };
        mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        this.intrinsicColorFilter = mutableStateOf$default;
        this.previousDrawSize = Size.INSTANCE.m2787getUnspecifiedNHjbRc();
        this.drawVectorBlock = new Function1<DrawScope, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComponent$drawVectorBlock$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(DrawScope drawScope) {
                invoke2(drawScope);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(DrawScope $this$null) {
                Intrinsics.checkNotNullParameter($this$null, "$this$null");
                GroupComponent $this$invoke_u24lambda_u240 = VectorComponent.this.getRoot();
                $this$invoke_u24lambda_u240.draw($this$null);
            }
        };
    }

    public final GroupComponent getRoot() {
        return this.root;
    }

    public final String getName() {
        return this.root.getName();
    }

    public final void setName(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.root.setName(value);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void doInvalidate() {
        this.isDirty = true;
        this.invalidateCallback.invoke();
    }

    public final Function0<Unit> getInvalidateCallback$ui_release() {
        return this.invalidateCallback;
    }

    public final void setInvalidateCallback$ui_release(Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "<set-?>");
        this.invalidateCallback = function0;
    }

    public final ColorFilter getIntrinsicColorFilter$ui_release() {
        State $this$getValue$iv = this.intrinsicColorFilter;
        return (ColorFilter) $this$getValue$iv.getValue();
    }

    public final void setIntrinsicColorFilter$ui_release(ColorFilter colorFilter) {
        MutableState $this$setValue$iv = this.intrinsicColorFilter;
        $this$setValue$iv.setValue(colorFilter);
    }

    public final float getViewportWidth() {
        return this.viewportWidth;
    }

    public final void setViewportWidth(float value) {
        if (!(this.viewportWidth == value)) {
            this.viewportWidth = value;
            doInvalidate();
        }
    }

    public final float getViewportHeight() {
        return this.viewportHeight;
    }

    public final void setViewportHeight(float value) {
        if (!(this.viewportHeight == value)) {
            this.viewportHeight = value;
            doInvalidate();
        }
    }

    public final void draw(DrawScope $this$draw, float alpha, ColorFilter colorFilter) {
        Intrinsics.checkNotNullParameter($this$draw, "<this>");
        ColorFilter targetColorFilter = colorFilter == null ? getIntrinsicColorFilter$ui_release() : colorFilter;
        if (this.isDirty || !Size.m2775equalsimpl0(this.previousDrawSize, $this$draw.mo3492getSizeNHjbRc())) {
            this.root.setScaleX(Size.m2779getWidthimpl($this$draw.mo3492getSizeNHjbRc()) / this.viewportWidth);
            this.root.setScaleY(Size.m2776getHeightimpl($this$draw.mo3492getSizeNHjbRc()) / this.viewportHeight);
            this.cacheDrawScope.m3568drawCachedImageCJJARo(IntSizeKt.IntSize((int) Math.ceil(Size.m2779getWidthimpl($this$draw.mo3492getSizeNHjbRc())), (int) Math.ceil(Size.m2776getHeightimpl($this$draw.mo3492getSizeNHjbRc()))), $this$draw, $this$draw.getLayoutDirection(), this.drawVectorBlock);
            this.isDirty = false;
            this.previousDrawSize = $this$draw.mo3492getSizeNHjbRc();
        }
        this.cacheDrawScope.drawInto($this$draw, alpha, targetColorFilter);
    }

    @Override // androidx.compose.ui.graphics.vector.VNode
    public void draw(DrawScope $this$draw) {
        Intrinsics.checkNotNullParameter($this$draw, "<this>");
        draw($this$draw, 1.0f, null);
    }

    public String toString() {
        StringBuilder $this$toString_u24lambda_u241 = new StringBuilder();
        $this$toString_u24lambda_u241.append("Params: ");
        $this$toString_u24lambda_u241.append("\tname: ").append(getName()).append("\n");
        $this$toString_u24lambda_u241.append("\tviewportWidth: ").append(this.viewportWidth).append("\n");
        $this$toString_u24lambda_u241.append("\tviewportHeight: ").append(this.viewportHeight).append("\n");
        String sb = $this$toString_u24lambda_u241.toString();
        Intrinsics.checkNotNullExpressionValue(sb, "StringBuilder().apply(builderAction).toString()");
        return sb;
    }
}
