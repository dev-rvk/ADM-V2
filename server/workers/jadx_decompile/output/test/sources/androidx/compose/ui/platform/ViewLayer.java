package androidx.compose.ui.platform;

import android.graphics.Matrix;
import android.graphics.Outline;
import android.graphics.Rect;
import android.os.Build;
import android.view.View;
import android.view.ViewOutlineProvider;
import androidx.compose.ui.geometry.MutableRect;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.CanvasHolder;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.TransformOrigin;
import androidx.compose.ui.layout.GraphicLayerInfo;
import androidx.compose.ui.node.OwnedLayer;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ViewLayer.android.kt */
@Metadata(d1 = {"\u0000Ø\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u0000 \u0082\u00012\u00020\u00012\u00020\u00022\u00020\u0003:\u0004\u0082\u0001\u0083\u0001B7\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\r¢\u0006\u0002\u0010\u000eJ\b\u00107\u001a\u00020\u000bH\u0016J\u0010\u00108\u001a\u00020\u000b2\u0006\u00109\u001a\u00020:H\u0014J\u0010\u0010;\u001a\u00020\u000b2\u0006\u00109\u001a\u00020\nH\u0016J\b\u0010<\u001a\u00020\u000bH\u0016J\b\u0010=\u001a\u00020\u001bH\u0016J\b\u0010>\u001a\u00020\u000bH\u0016J\u001d\u0010?\u001a\u00020\u000b2\u0006\u0010@\u001a\u00020AH\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bB\u0010CJ\u001d\u0010D\u001a\u00020\u001b2\u0006\u0010E\u001a\u00020FH\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bG\u0010HJ\u0018\u0010I\u001a\u00020\u000b2\u0006\u0010J\u001a\u00020K2\u0006\u0010L\u001a\u00020\u001bH\u0016J%\u0010M\u001a\u00020F2\u0006\u0010N\u001a\u00020F2\u0006\u0010L\u001a\u00020\u001bH\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bO\u0010PJ\u001d\u0010Q\u001a\u00020\u000b2\u0006\u0010E\u001a\u00020RH\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bS\u0010TJ0\u0010U\u001a\u00020\u000b2\u0006\u0010V\u001a\u00020\u001b2\u0006\u0010W\u001a\u00020X2\u0006\u0010Y\u001a\u00020X2\u0006\u0010Z\u001a\u00020X2\u0006\u0010[\u001a\u00020XH\u0014J\b\u0010\\\u001a\u00020\u000bH\u0002J\u001d\u0010]\u001a\u00020\u000b2\u0006\u0010^\u001a\u00020_H\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b`\u0010TJ*\u0010a\u001a\u00020\u000b2\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\rH\u0016J\u001d\u0010b\u001a\u00020\u000b2\u0006\u0010@\u001a\u00020AH\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bc\u0010CJ\b\u0010d\u001a\u00020\u000bH\u0016J°\u0001\u0010e\u001a\u00020\u000b2\u0006\u0010f\u001a\u00020\u00102\u0006\u0010g\u001a\u00020\u00102\u0006\u0010h\u001a\u00020\u00102\u0006\u0010i\u001a\u00020\u00102\u0006\u0010j\u001a\u00020\u00102\u0006\u0010k\u001a\u00020\u00102\u0006\u0010l\u001a\u00020\u00102\u0006\u0010m\u001a\u00020\u00102\u0006\u0010n\u001a\u00020\u00102\u0006\u0010o\u001a\u00020\u00102\u0006\u0010p\u001a\u00020)2\u0006\u0010q\u001a\u00020r2\u0006\u0010s\u001a\u00020\u001b2\b\u0010t\u001a\u0004\u0018\u00010u2\u0006\u0010v\u001a\u00020w2\u0006\u0010x\u001a\u00020w2\u0006\u0010y\u001a\u00020z2\u0006\u0010{\u001a\u00020|2\u0006\u0010}\u001a\u00020~H\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0005\b\u007f\u0010\u0080\u0001J\t\u0010\u0081\u0001\u001a\u00020\u000bH\u0002R$\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u00108F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u001c\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010\u001f\u001a\u00020\u001b2\u0006\u0010\u000f\u001a\u00020\u001b@BX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u0014\u0010#\u001a\u00020$X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u000e\u0010'\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0019\u0010(\u001a\u00020)X\u0082\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010*R\u0016\u0010+\u001a\u0004\u0018\u00010,8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b-\u0010.R\u0014\u0010/\u001a\b\u0012\u0004\u0012\u00020\u000100X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u000202X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b3\u00104R\u0014\u00105\u001a\u00020$8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b6\u0010&\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0084\u0001"}, d2 = {"Landroidx/compose/ui/platform/ViewLayer;", "Landroid/view/View;", "Landroidx/compose/ui/node/OwnedLayer;", "Landroidx/compose/ui/layout/GraphicLayerInfo;", "ownerView", "Landroidx/compose/ui/platform/AndroidComposeView;", "container", "Landroidx/compose/ui/platform/DrawChildContainer;", "drawBlock", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/Canvas;", "", "invalidateParentLayer", "Lkotlin/Function0;", "(Landroidx/compose/ui/platform/AndroidComposeView;Landroidx/compose/ui/platform/DrawChildContainer;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;)V", "value", "", "cameraDistancePx", "getCameraDistancePx", "()F", "setCameraDistancePx", "(F)V", "canvasHolder", "Landroidx/compose/ui/graphics/CanvasHolder;", "clipBoundsCache", "Landroid/graphics/Rect;", "clipToBounds", "", "getContainer", "()Landroidx/compose/ui/platform/DrawChildContainer;", "drawnWithZ", "isInvalidated", "()Z", "setInvalidated", "(Z)V", "layerId", "", "getLayerId", "()J", "mHasOverlappingRendering", "mTransformOrigin", "Landroidx/compose/ui/graphics/TransformOrigin;", "J", "manualClipPath", "Landroidx/compose/ui/graphics/Path;", "getManualClipPath", "()Landroidx/compose/ui/graphics/Path;", "matrixCache", "Landroidx/compose/ui/platform/LayerMatrixCache;", "outlineResolver", "Landroidx/compose/ui/platform/OutlineResolver;", "getOwnerView", "()Landroidx/compose/ui/platform/AndroidComposeView;", "ownerViewId", "getOwnerViewId", "destroy", "dispatchDraw", "canvas", "Landroid/graphics/Canvas;", "drawLayer", "forceLayout", "hasOverlappingRendering", "invalidate", "inverseTransform", "matrix", "Landroidx/compose/ui/graphics/Matrix;", "inverseTransform-58bKbWc", "([F)V", "isInLayer", "position", "Landroidx/compose/ui/geometry/Offset;", "isInLayer-k-4lQ0M", "(J)Z", "mapBounds", "rect", "Landroidx/compose/ui/geometry/MutableRect;", "inverse", "mapOffset", "point", "mapOffset-8S9VItk", "(JZ)J", "move", "Landroidx/compose/ui/unit/IntOffset;", "move--gyyYBs", "(J)V", "onLayout", "changed", "l", "", "t", "r", "b", "resetClipBounds", "resize", "size", "Landroidx/compose/ui/unit/IntSize;", "resize-ozmzZPI", "reuseLayer", "transform", "transform-58bKbWc", "updateDisplayList", "updateLayerProperties", "scaleX", "scaleY", "alpha", "translationX", "translationY", "shadowElevation", "rotationX", "rotationY", "rotationZ", "cameraDistance", "transformOrigin", "shape", "Landroidx/compose/ui/graphics/Shape;", "clip", "renderEffect", "Landroidx/compose/ui/graphics/RenderEffect;", "ambientShadowColor", "Landroidx/compose/ui/graphics/Color;", "spotShadowColor", "compositingStrategy", "Landroidx/compose/ui/graphics/CompositingStrategy;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "density", "Landroidx/compose/ui/unit/Density;", "updateLayerProperties-dDxr-wY", "(FFFFFFFFFFJLandroidx/compose/ui/graphics/Shape;ZLandroidx/compose/ui/graphics/RenderEffect;JJILandroidx/compose/ui/unit/LayoutDirection;Landroidx/compose/ui/unit/Density;)V", "updateOutlineResolver", "Companion", "UniqueDrawingIdApi29", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class ViewLayer extends View implements OwnedLayer, GraphicLayerInfo {
    private static boolean hasRetrievedMethod;
    private static Field recreateDisplayList;
    private static boolean shouldUseDispatchDraw;
    private static Method updateDisplayListIfDirtyMethod;
    private final CanvasHolder canvasHolder;
    private Rect clipBoundsCache;
    private boolean clipToBounds;
    private final DrawChildContainer container;
    private Function1<? super Canvas, Unit> drawBlock;
    private boolean drawnWithZ;
    private Function0<Unit> invalidateParentLayer;
    private boolean isInvalidated;
    private final long layerId;
    private boolean mHasOverlappingRendering;
    private long mTransformOrigin;
    private final LayerMatrixCache<View> matrixCache;
    private final OutlineResolver outlineResolver;
    private final AndroidComposeView ownerView;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Function2<View, Matrix, Unit> getMatrix = new Function2<View, Matrix, Unit>() { // from class: androidx.compose.ui.platform.ViewLayer$Companion$getMatrix$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(View view, Matrix matrix) {
            invoke2(view, matrix);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(View view, Matrix matrix) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(matrix, "matrix");
            Matrix newMatrix = view.getMatrix();
            matrix.set(newMatrix);
        }
    };
    private static final ViewOutlineProvider OutlineProvider = new ViewOutlineProvider() { // from class: androidx.compose.ui.platform.ViewLayer$Companion$OutlineProvider$1
        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            OutlineResolver outlineResolver;
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(outline, "outline");
            outlineResolver = ((ViewLayer) view).outlineResolver;
            Outline outline2 = outlineResolver.getOutline();
            Intrinsics.checkNotNull(outline2);
            outline.set(outline2);
        }
    };

    public final AndroidComposeView getOwnerView() {
        return this.ownerView;
    }

    public final DrawChildContainer getContainer() {
        return this.container;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ViewLayer(AndroidComposeView ownerView, DrawChildContainer container, Function1<? super Canvas, Unit> drawBlock, Function0<Unit> invalidateParentLayer) {
        super(ownerView.getContext());
        Intrinsics.checkNotNullParameter(ownerView, "ownerView");
        Intrinsics.checkNotNullParameter(container, "container");
        Intrinsics.checkNotNullParameter(drawBlock, "drawBlock");
        Intrinsics.checkNotNullParameter(invalidateParentLayer, "invalidateParentLayer");
        this.ownerView = ownerView;
        this.container = container;
        this.drawBlock = drawBlock;
        this.invalidateParentLayer = invalidateParentLayer;
        this.outlineResolver = new OutlineResolver(this.ownerView.getDensity());
        this.canvasHolder = new CanvasHolder();
        this.matrixCache = new LayerMatrixCache<>(getMatrix);
        this.mTransformOrigin = TransformOrigin.INSTANCE.m3333getCenterSzJe1aQ();
        this.mHasOverlappingRendering = true;
        setWillNotDraw(false);
        this.container.addView(this);
        this.layerId = View.generateViewId();
    }

    private final Path getManualClipPath() {
        if (!getClipToOutline() || this.outlineResolver.getOutlineClipSupported()) {
            return null;
        }
        return this.outlineResolver.getClipPath();
    }

    /* renamed from: isInvalidated, reason: from getter */
    public final boolean getIsInvalidated() {
        return this.isInvalidated;
    }

    private final void setInvalidated(boolean value) {
        if (value != this.isInvalidated) {
            this.isInvalidated = value;
            this.ownerView.notifyLayerIsDirty$ui_release(this, value);
        }
    }

    @Override // androidx.compose.ui.layout.GraphicLayerInfo
    public long getLayerId() {
        return this.layerId;
    }

    @Override // androidx.compose.ui.layout.GraphicLayerInfo
    public long getOwnerViewId() {
        if (Build.VERSION.SDK_INT >= 29) {
            return UniqueDrawingIdApi29.getUniqueDrawingId(this.ownerView);
        }
        return -1L;
    }

    /* compiled from: ViewLayer.android.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\bÃ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Landroidx/compose/ui/platform/ViewLayer$UniqueDrawingIdApi29;", "", "()V", "getUniqueDrawingId", "", "view", "Landroid/view/View;", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes.dex */
    private static final class UniqueDrawingIdApi29 {
        public static final UniqueDrawingIdApi29 INSTANCE = new UniqueDrawingIdApi29();

        private UniqueDrawingIdApi29() {
        }

        @JvmStatic
        public static final long getUniqueDrawingId(View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            return view.getUniqueDrawingId();
        }
    }

    public final float getCameraDistancePx() {
        return getCameraDistance() / getResources().getDisplayMetrics().densityDpi;
    }

    public final void setCameraDistancePx(float value) {
        setCameraDistance(getResources().getDisplayMetrics().densityDpi * value);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0113  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x012e  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0135  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00cc  */
    @Override // androidx.compose.ui.node.OwnedLayer
    /* renamed from: updateLayerProperties-dDxr-wY */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void mo4451updateLayerPropertiesdDxrwY(float r22, float r23, float r24, float r25, float r26, float r27, float r28, float r29, float r30, float r31, long r32, androidx.compose.ui.graphics.Shape r34, boolean r35, androidx.compose.ui.graphics.RenderEffect r36, long r37, long r39, int r41, androidx.compose.ui.unit.LayoutDirection r42, androidx.compose.ui.unit.Density r43) {
        /*
            Method dump skipped, instructions count: 335
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.platform.ViewLayer.mo4451updateLayerPropertiesdDxrwY(float, float, float, float, float, float, float, float, float, float, long, androidx.compose.ui.graphics.Shape, boolean, androidx.compose.ui.graphics.RenderEffect, long, long, int, androidx.compose.ui.unit.LayoutDirection, androidx.compose.ui.unit.Density):void");
    }

    @Override // android.view.View
    public boolean hasOverlappingRendering() {
        return this.mHasOverlappingRendering;
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    /* renamed from: isInLayer-k-4lQ0M */
    public boolean mo4446isInLayerk4lQ0M(long position) {
        float x = Offset.m2710getXimpl(position);
        float y = Offset.m2711getYimpl(position);
        if (this.clipToBounds) {
            return 0.0f <= x && x < ((float) getWidth()) && 0.0f <= y && y < ((float) getHeight());
        }
        if (getClipToOutline()) {
            return this.outlineResolver.m4542isInOutlinek4lQ0M(position);
        }
        return true;
    }

    private final void updateOutlineResolver() {
        ViewOutlineProvider viewOutlineProvider;
        if (this.outlineResolver.getOutline() != null) {
            viewOutlineProvider = OutlineProvider;
        } else {
            viewOutlineProvider = null;
        }
        setOutlineProvider(viewOutlineProvider);
    }

    private final void resetClipBounds() {
        Rect rect;
        if (this.clipToBounds) {
            if (this.clipBoundsCache == null) {
                this.clipBoundsCache = new Rect(0, 0, getWidth(), getHeight());
            } else {
                Rect rect2 = this.clipBoundsCache;
                Intrinsics.checkNotNull(rect2);
                rect2.set(0, 0, getWidth(), getHeight());
            }
            rect = this.clipBoundsCache;
        } else {
            rect = null;
        }
        setClipBounds(rect);
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    /* renamed from: resize-ozmzZPI */
    public void mo4449resizeozmzZPI(long size) {
        int width = IntSize.m5378getWidthimpl(size);
        int height = IntSize.m5377getHeightimpl(size);
        if (width != getWidth() || height != getHeight()) {
            setPivotX(TransformOrigin.m3328getPivotFractionXimpl(this.mTransformOrigin) * width);
            setPivotY(TransformOrigin.m3329getPivotFractionYimpl(this.mTransformOrigin) * height);
            this.outlineResolver.m4543updateuvyYCjk(SizeKt.Size(width, height));
            updateOutlineResolver();
            layout(getLeft(), getTop(), getLeft() + width, getTop() + height);
            resetClipBounds();
            this.matrixCache.invalidate();
        }
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    /* renamed from: move--gyyYBs */
    public void mo4448movegyyYBs(long position) {
        int left = IntOffset.m5336getXimpl(position);
        if (left != getLeft()) {
            offsetLeftAndRight(left - getLeft());
            this.matrixCache.invalidate();
        }
        int top = IntOffset.m5337getYimpl(position);
        if (top != getTop()) {
            offsetTopAndBottom(top - getTop());
            this.matrixCache.invalidate();
        }
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    public void drawLayer(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        this.drawnWithZ = getElevation() > 0.0f;
        if (this.drawnWithZ) {
            canvas.enableZ();
        }
        this.container.drawChild$ui_release(canvas, this, getDrawingTime());
        if (this.drawnWithZ) {
            canvas.disableZ();
        }
    }

    @Override // android.view.View
    protected void dispatchDraw(android.graphics.Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        setInvalidated(false);
        CanvasHolder this_$iv = this.canvasHolder;
        android.graphics.Canvas previousCanvas$iv = this_$iv.getAndroidCanvas().getInternalCanvas();
        this_$iv.getAndroidCanvas().setInternalCanvas(canvas);
        Canvas $this$dispatchDraw_u24lambda_u240 = this_$iv.getAndroidCanvas();
        boolean didClip = false;
        Path clipPath = getManualClipPath();
        if (clipPath != null || !canvas.isHardwareAccelerated()) {
            didClip = true;
            $this$dispatchDraw_u24lambda_u240.save();
            this.outlineResolver.clipToOutline($this$dispatchDraw_u24lambda_u240);
        }
        Function1<? super Canvas, Unit> function1 = this.drawBlock;
        if (function1 != null) {
            function1.invoke($this$dispatchDraw_u24lambda_u240);
        }
        if (didClip) {
            $this$dispatchDraw_u24lambda_u240.restore();
        }
        this_$iv.getAndroidCanvas().setInternalCanvas(previousCanvas$iv);
    }

    @Override // android.view.View, androidx.compose.ui.node.OwnedLayer
    public void invalidate() {
        if (!this.isInvalidated) {
            setInvalidated(true);
            super.invalidate();
            this.ownerView.invalidate();
        }
    }

    @Override // android.view.View
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    public void destroy() {
        setInvalidated(false);
        this.ownerView.requestClearInvalidObservations();
        this.drawBlock = null;
        this.invalidateParentLayer = null;
        this.ownerView.recycle$ui_release(this);
        this.container.removeViewInLayout(this);
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    public void updateDisplayList() {
        if (this.isInvalidated && !shouldUseDispatchDraw) {
            setInvalidated(false);
            INSTANCE.updateDisplayList(this);
        }
    }

    @Override // android.view.View
    public void forceLayout() {
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    /* renamed from: mapOffset-8S9VItk */
    public long mo4447mapOffset8S9VItk(long point, boolean inverse) {
        if (inverse) {
            float[] m4519calculateInverseMatrixbWbORWo = this.matrixCache.m4519calculateInverseMatrixbWbORWo(this);
            return m4519calculateInverseMatrixbWbORWo != null ? androidx.compose.ui.graphics.Matrix.m3180mapMKHz9U(m4519calculateInverseMatrixbWbORWo, point) : Offset.INSTANCE.m2724getInfiniteF1C5BW0();
        }
        return androidx.compose.ui.graphics.Matrix.m3180mapMKHz9U(this.matrixCache.m4520calculateMatrixGrdbGEg(this), point);
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    public void mapBounds(MutableRect rect, boolean inverse) {
        Intrinsics.checkNotNullParameter(rect, "rect");
        if (inverse) {
            float[] matrix = this.matrixCache.m4519calculateInverseMatrixbWbORWo(this);
            if (matrix != null) {
                androidx.compose.ui.graphics.Matrix.m3182mapimpl(matrix, rect);
                return;
            } else {
                rect.set(0.0f, 0.0f, 0.0f, 0.0f);
                return;
            }
        }
        androidx.compose.ui.graphics.Matrix.m3182mapimpl(this.matrixCache.m4520calculateMatrixGrdbGEg(this), rect);
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    public void reuseLayer(Function1<? super Canvas, Unit> drawBlock, Function0<Unit> invalidateParentLayer) {
        Intrinsics.checkNotNullParameter(drawBlock, "drawBlock");
        Intrinsics.checkNotNullParameter(invalidateParentLayer, "invalidateParentLayer");
        this.container.addView(this);
        this.clipToBounds = false;
        this.drawnWithZ = false;
        this.mTransformOrigin = TransformOrigin.INSTANCE.m3333getCenterSzJe1aQ();
        this.drawBlock = drawBlock;
        this.invalidateParentLayer = invalidateParentLayer;
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    /* renamed from: transform-58bKbWc */
    public void mo4450transform58bKbWc(float[] matrix) {
        Intrinsics.checkNotNullParameter(matrix, "matrix");
        androidx.compose.ui.graphics.Matrix.m3191timesAssign58bKbWc(matrix, this.matrixCache.m4520calculateMatrixGrdbGEg(this));
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    /* renamed from: inverseTransform-58bKbWc */
    public void mo4445inverseTransform58bKbWc(float[] matrix) {
        Intrinsics.checkNotNullParameter(matrix, "matrix");
        float[] inverse = this.matrixCache.m4519calculateInverseMatrixbWbORWo(this);
        if (inverse != null) {
            androidx.compose.ui.graphics.Matrix.m3191timesAssign58bKbWc(matrix, inverse);
        }
    }

    /* compiled from: ViewLayer.android.kt */
    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\tH\u0007R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R \u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\r@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010\u0013\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\r@@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0016R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Landroidx/compose/ui/platform/ViewLayer$Companion;", "", "()V", "OutlineProvider", "Landroid/view/ViewOutlineProvider;", "getOutlineProvider", "()Landroid/view/ViewOutlineProvider;", "getMatrix", "Lkotlin/Function2;", "Landroid/view/View;", "Landroid/graphics/Matrix;", "", "<set-?>", "", "hasRetrievedMethod", "getHasRetrievedMethod", "()Z", "recreateDisplayList", "Ljava/lang/reflect/Field;", "shouldUseDispatchDraw", "getShouldUseDispatchDraw", "setShouldUseDispatchDraw$ui_release", "(Z)V", "updateDisplayListIfDirtyMethod", "Ljava/lang/reflect/Method;", "updateDisplayList", "view", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ViewOutlineProvider getOutlineProvider() {
            return ViewLayer.OutlineProvider;
        }

        public final boolean getHasRetrievedMethod() {
            return ViewLayer.hasRetrievedMethod;
        }

        public final boolean getShouldUseDispatchDraw() {
            return ViewLayer.shouldUseDispatchDraw;
        }

        public final void setShouldUseDispatchDraw$ui_release(boolean z) {
            ViewLayer.shouldUseDispatchDraw = z;
        }

        public final void updateDisplayList(View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            try {
                if (!getHasRetrievedMethod()) {
                    ViewLayer.hasRetrievedMethod = true;
                    if (Build.VERSION.SDK_INT < 28) {
                        ViewLayer.updateDisplayListIfDirtyMethod = View.class.getDeclaredMethod("updateDisplayListIfDirty", new Class[0]);
                        ViewLayer.recreateDisplayList = View.class.getDeclaredField("mRecreateDisplayList");
                    } else {
                        ViewLayer.updateDisplayListIfDirtyMethod = (Method) Class.class.getDeclaredMethod("getDeclaredMethod", String.class, new Class[0].getClass()).invoke(View.class, "updateDisplayListIfDirty", new Class[0]);
                        Method getDeclaredField = Class.class.getDeclaredMethod("getDeclaredField", String.class);
                        ViewLayer.recreateDisplayList = (Field) getDeclaredField.invoke(View.class, "mRecreateDisplayList");
                    }
                    Method getDeclaredMethod = ViewLayer.updateDisplayListIfDirtyMethod;
                    if (getDeclaredMethod != null) {
                        getDeclaredMethod.setAccessible(true);
                    }
                    Field field = ViewLayer.recreateDisplayList;
                    if (field != null) {
                        field.setAccessible(true);
                    }
                }
                Field field2 = ViewLayer.recreateDisplayList;
                if (field2 != null) {
                    field2.setBoolean(view, true);
                }
                Method method = ViewLayer.updateDisplayListIfDirtyMethod;
                if (method != null) {
                    method.invoke(view, new Object[0]);
                }
            } catch (Throwable th) {
                setShouldUseDispatchDraw$ui_release(true);
            }
        }
    }
}
