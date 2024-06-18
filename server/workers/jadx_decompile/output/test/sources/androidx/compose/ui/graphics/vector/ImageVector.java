package androidx.compose.ui.graphics.vector;

import androidx.autofill.HintConstants;
import androidx.compose.ui.graphics.BlendMode;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.unit.Dp;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.ArrayList;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ImageVector.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0016\n\u0002\u0010\b\n\u0002\b\u0003\b\u0007\u0018\u0000 *2\u00020\u0001:\u0002)*BR\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011ø\u0001\u0000¢\u0006\u0002\u0010\u0012J\u0013\u0010%\u001a\u00020\u00112\b\u0010&\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010'\u001a\u00020(H\u0016R\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0006\u001a\u00020\u0005ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0004\u001a\u00020\u0005ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0018\u0010\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u001c\u0010\u000e\u001a\u00020\u000fø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b\u001d\u0010\u001eR\u001c\u0010\f\u001a\u00020\rø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\"\u001a\u0004\b \u0010!R\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0016R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0016\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006+"}, d2 = {"Landroidx/compose/ui/graphics/vector/ImageVector;", "", HintConstants.AUTOFILL_HINT_NAME, "", "defaultWidth", "Landroidx/compose/ui/unit/Dp;", "defaultHeight", "viewportWidth", "", "viewportHeight", "root", "Landroidx/compose/ui/graphics/vector/VectorGroup;", "tintColor", "Landroidx/compose/ui/graphics/Color;", "tintBlendMode", "Landroidx/compose/ui/graphics/BlendMode;", "autoMirror", "", "(Ljava/lang/String;FFFFLandroidx/compose/ui/graphics/vector/VectorGroup;JIZLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getAutoMirror", "()Z", "getDefaultHeight-D9Ej5fM", "()F", "F", "getDefaultWidth-D9Ej5fM", "getName", "()Ljava/lang/String;", "getRoot", "()Landroidx/compose/ui/graphics/vector/VectorGroup;", "getTintBlendMode-0nO6VwU", "()I", "I", "getTintColor-0d7_KjU", "()J", "J", "getViewportHeight", "getViewportWidth", "equals", "other", "hashCode", "", "Builder", "Companion", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class ImageVector {
    public static final int $stable = 0;
    private final boolean autoMirror;
    private final float defaultHeight;
    private final float defaultWidth;
    private final String name;
    private final VectorGroup root;
    private final int tintBlendMode;
    private final long tintColor;
    private final float viewportHeight;
    private final float viewportWidth;

    public /* synthetic */ ImageVector(String str, float f, float f2, float f3, float f4, VectorGroup vectorGroup, long j, int i, boolean z, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, f, f2, f3, f4, vectorGroup, j, i, z);
    }

    private ImageVector(String name, float defaultWidth, float defaultHeight, float viewportWidth, float viewportHeight, VectorGroup root, long tintColor, int tintBlendMode, boolean autoMirror) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(root, "root");
        this.name = name;
        this.defaultWidth = defaultWidth;
        this.defaultHeight = defaultHeight;
        this.viewportWidth = viewportWidth;
        this.viewportHeight = viewportHeight;
        this.root = root;
        this.tintColor = tintColor;
        this.tintBlendMode = tintBlendMode;
        this.autoMirror = autoMirror;
    }

    public final String getName() {
        return this.name;
    }

    /* renamed from: getDefaultWidth-D9Ej5fM, reason: not valid java name and from getter */
    public final float getDefaultWidth() {
        return this.defaultWidth;
    }

    /* renamed from: getDefaultHeight-D9Ej5fM, reason: not valid java name and from getter */
    public final float getDefaultHeight() {
        return this.defaultHeight;
    }

    public final float getViewportWidth() {
        return this.viewportWidth;
    }

    public final float getViewportHeight() {
        return this.viewportHeight;
    }

    public final VectorGroup getRoot() {
        return this.root;
    }

    /* renamed from: getTintColor-0d7_KjU, reason: not valid java name and from getter */
    public final long getTintColor() {
        return this.tintColor;
    }

    /* renamed from: getTintBlendMode-0nO6VwU, reason: not valid java name and from getter */
    public final int getTintBlendMode() {
        return this.tintBlendMode;
    }

    public final boolean getAutoMirror() {
        return this.autoMirror;
    }

    /* compiled from: ImageVector.kt */
    @Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001DBH\b\u0017\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\rø\u0001\u0000¢\u0006\u0002\u0010\u000eBP\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0010ø\u0001\u0000¢\u0006\u0002\u0010\u0011Jf\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u001f\u001a\u00020\b2\b\b\u0002\u0010 \u001a\u00020\b2\b\b\u0002\u0010!\u001a\u00020\b2\b\b\u0002\u0010\"\u001a\u00020\b2\b\b\u0002\u0010#\u001a\u00020\b2\b\b\u0002\u0010$\u001a\u00020\b2\b\b\u0002\u0010%\u001a\u00020\b2\u000e\b\u0002\u0010&\u001a\b\u0012\u0004\u0012\u00020(0'J§\u0001\u0010)\u001a\u00020\u00002\f\u0010*\u001a\b\u0012\u0004\u0012\u00020(0'2\b\b\u0002\u0010+\u001a\u00020,2\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010-\u001a\u0004\u0018\u00010.2\b\b\u0002\u0010/\u001a\u00020\b2\n\b\u0002\u00100\u001a\u0004\u0018\u00010.2\b\b\u0002\u00101\u001a\u00020\b2\b\b\u0002\u00102\u001a\u00020\b2\b\b\u0002\u00103\u001a\u0002042\b\b\u0002\u00105\u001a\u0002062\b\b\u0002\u00107\u001a\u00020\b2\b\b\u0002\u00108\u001a\u00020\b2\b\b\u0002\u00109\u001a\u00020\b2\b\b\u0002\u0010:\u001a\u00020\bø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b;\u0010<J\u0006\u0010=\u001a\u00020>J\u0006\u0010?\u001a\u00020\u0000J\b\u0010@\u001a\u00020AH\u0002J\f\u0010B\u001a\u00020C*\u00020\u0013H\u0002R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\u00020\u00138BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0019\u0010\u0006\u001a\u00020\u0005X\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0016R\u0019\u0010\u0004\u001a\u00020\u0005X\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0016R\u000e\u0010\u0017\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0018\u001a\u0012\u0012\u0004\u0012\u00020\u00130\u0019j\b\u0012\u0004\u0012\u00020\u0013`\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0019\u0010\f\u001a\u00020\rX\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u001cR\u0019\u0010\n\u001a\u00020\u000bX\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u001dR\u000e\u0010\t\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006E"}, d2 = {"Landroidx/compose/ui/graphics/vector/ImageVector$Builder;", "", HintConstants.AUTOFILL_HINT_NAME, "", "defaultWidth", "Landroidx/compose/ui/unit/Dp;", "defaultHeight", "viewportWidth", "", "viewportHeight", "tintColor", "Landroidx/compose/ui/graphics/Color;", "tintBlendMode", "Landroidx/compose/ui/graphics/BlendMode;", "(Ljava/lang/String;FFFFJILkotlin/jvm/internal/DefaultConstructorMarker;)V", "autoMirror", "", "(Ljava/lang/String;FFFFJIZLkotlin/jvm/internal/DefaultConstructorMarker;)V", "currentGroup", "Landroidx/compose/ui/graphics/vector/ImageVector$Builder$GroupParams;", "getCurrentGroup", "()Landroidx/compose/ui/graphics/vector/ImageVector$Builder$GroupParams;", "F", "isConsumed", "nodes", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "root", "I", "J", "addGroup", "rotate", "pivotX", "pivotY", "scaleX", "scaleY", "translationX", "translationY", "clipPathData", "", "Landroidx/compose/ui/graphics/vector/PathNode;", "addPath", "pathData", "pathFillType", "Landroidx/compose/ui/graphics/PathFillType;", "fill", "Landroidx/compose/ui/graphics/Brush;", "fillAlpha", "stroke", "strokeAlpha", "strokeLineWidth", "strokeLineCap", "Landroidx/compose/ui/graphics/StrokeCap;", "strokeLineJoin", "Landroidx/compose/ui/graphics/StrokeJoin;", "strokeLineMiter", "trimPathStart", "trimPathEnd", "trimPathOffset", "addPath-oIyEayM", "(Ljava/util/List;ILjava/lang/String;Landroidx/compose/ui/graphics/Brush;FLandroidx/compose/ui/graphics/Brush;FFIIFFFF)Landroidx/compose/ui/graphics/vector/ImageVector$Builder;", "build", "Landroidx/compose/ui/graphics/vector/ImageVector;", "clearGroup", "ensureNotConsumed", "", "asVectorGroup", "Landroidx/compose/ui/graphics/vector/VectorGroup;", "GroupParams", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes.dex */
    public static final class Builder {
        public static final int $stable = 8;
        private final boolean autoMirror;
        private final float defaultHeight;
        private final float defaultWidth;
        private boolean isConsumed;
        private final String name;
        private final ArrayList<GroupParams> nodes;
        private GroupParams root;
        private final int tintBlendMode;
        private final long tintColor;
        private final float viewportHeight;
        private final float viewportWidth;

        @Deprecated(level = DeprecationLevel.HIDDEN, message = "Replace with ImageVector.Builder that consumes an optional auto mirror parameter", replaceWith = @ReplaceWith(expression = "Builder(name, defaultWidth, defaultHeight, viewportWidth, viewportHeight, tintColor, tintBlendMode, false)", imports = {"androidx.compose.ui.graphics.vector"}))
        public /* synthetic */ Builder(String str, float f, float f2, float f3, float f4, long j, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, f, f2, f3, f4, j, i);
        }

        public /* synthetic */ Builder(String str, float f, float f2, float f3, float f4, long j, int i, boolean z, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, f, f2, f3, f4, j, i, z);
        }

        private Builder(String name, float defaultWidth, float defaultHeight, float viewportWidth, float viewportHeight, long tintColor, int tintBlendMode, boolean autoMirror) {
            Intrinsics.checkNotNullParameter(name, "name");
            this.name = name;
            this.defaultWidth = defaultWidth;
            this.defaultHeight = defaultHeight;
            this.viewportWidth = viewportWidth;
            this.viewportHeight = viewportHeight;
            this.tintColor = tintColor;
            this.tintBlendMode = tintBlendMode;
            this.autoMirror = autoMirror;
            this.nodes = new ArrayList<>();
            this.root = new GroupParams(null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, 1023, null);
            ImageVectorKt.access$push(this.nodes, this.root);
        }

        public /* synthetic */ Builder(String str, float f, float f2, float f3, float f4, long j, int i, boolean z, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this((i2 & 1) != 0 ? "" : str, f, f2, f3, f4, (i2 & 32) != 0 ? Color.INSTANCE.m2985getUnspecified0d7_KjU() : j, (i2 & 64) != 0 ? BlendMode.INSTANCE.m2891getSrcIn0nO6VwU() : i, (i2 & 128) != 0 ? false : z, (DefaultConstructorMarker) null);
        }

        public /* synthetic */ Builder(String str, float f, float f2, float f3, float f4, long j, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this((i2 & 1) != 0 ? "" : str, f, f2, f3, f4, (i2 & 32) != 0 ? Color.INSTANCE.m2985getUnspecified0d7_KjU() : j, (i2 & 64) != 0 ? BlendMode.INSTANCE.m2891getSrcIn0nO6VwU() : i, (DefaultConstructorMarker) null);
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        private Builder(String name, float defaultWidth, float defaultHeight, float viewportWidth, float viewportHeight, long tintColor, int tintBlendMode) {
            this(name, defaultWidth, defaultHeight, viewportWidth, viewportHeight, tintColor, tintBlendMode, false, (DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(name, "name");
        }

        private final GroupParams getCurrentGroup() {
            return (GroupParams) ImageVectorKt.access$peek(this.nodes);
        }

        public final Builder addGroup(String name, float rotate, float pivotX, float pivotY, float scaleX, float scaleY, float translationX, float translationY, List<? extends PathNode> clipPathData) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(clipPathData, "clipPathData");
            ensureNotConsumed();
            GroupParams group = new GroupParams(name, rotate, pivotX, pivotY, scaleX, scaleY, translationX, translationY, clipPathData, null, 512, null);
            ImageVectorKt.access$push(this.nodes, group);
            return this;
        }

        public final Builder clearGroup() {
            ensureNotConsumed();
            GroupParams popped = (GroupParams) ImageVectorKt.access$pop(this.nodes);
            getCurrentGroup().getChildren().add(asVectorGroup(popped));
            return this;
        }

        /* renamed from: addPath-oIyEayM, reason: not valid java name */
        public final Builder m3574addPathoIyEayM(List<? extends PathNode> pathData, int pathFillType, String name, Brush fill, float fillAlpha, Brush stroke, float strokeAlpha, float strokeLineWidth, int strokeLineCap, int strokeLineJoin, float strokeLineMiter, float trimPathStart, float trimPathEnd, float trimPathOffset) {
            Intrinsics.checkNotNullParameter(pathData, "pathData");
            Intrinsics.checkNotNullParameter(name, "name");
            ensureNotConsumed();
            getCurrentGroup().getChildren().add(new VectorPath(name, pathData, pathFillType, fill, fillAlpha, stroke, strokeAlpha, strokeLineWidth, strokeLineCap, strokeLineJoin, strokeLineMiter, trimPathStart, trimPathEnd, trimPathOffset, null));
            return this;
        }

        public final ImageVector build() {
            ensureNotConsumed();
            while (this.nodes.size() > 1) {
                clearGroup();
            }
            ImageVector vectorImage = new ImageVector(this.name, this.defaultWidth, this.defaultHeight, this.viewportWidth, this.viewportHeight, asVectorGroup(this.root), this.tintColor, this.tintBlendMode, this.autoMirror, null);
            this.isConsumed = true;
            return vectorImage;
        }

        private final void ensureNotConsumed() {
            if (!(!this.isConsumed)) {
                throw new IllegalStateException("ImageVector.Builder is single use, create a new instance to create a new ImageVector".toString());
            }
        }

        private final VectorGroup asVectorGroup(GroupParams $this$asVectorGroup) {
            return new VectorGroup($this$asVectorGroup.getName(), $this$asVectorGroup.getRotate(), $this$asVectorGroup.getPivotX(), $this$asVectorGroup.getPivotY(), $this$asVectorGroup.getScaleX(), $this$asVectorGroup.getScaleY(), $this$asVectorGroup.getTranslationX(), $this$asVectorGroup.getTranslationY(), $this$asVectorGroup.getClipPathData(), $this$asVectorGroup.getChildren());
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* compiled from: ImageVector.kt */
        @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u001c\b\u0002\u0018\u00002\u00020\u0001Bu\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005\u0012\b\b\u0002\u0010\n\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0005\u0012\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010¢\u0006\u0002\u0010\u0012R \u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R \u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0014\"\u0004\b\u0018\u0010\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001a\u0010\u0007\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u001e\"\u0004\b\"\u0010 R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u001e\"\u0004\b$\u0010 R\u001a\u0010\b\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u001e\"\u0004\b&\u0010 R\u001a\u0010\t\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u001e\"\u0004\b(\u0010 R\u001a\u0010\n\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u001e\"\u0004\b*\u0010 R\u001a\u0010\u000b\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u001e\"\u0004\b,\u0010 ¨\u0006-"}, d2 = {"Landroidx/compose/ui/graphics/vector/ImageVector$Builder$GroupParams;", "", HintConstants.AUTOFILL_HINT_NAME, "", "rotate", "", "pivotX", "pivotY", "scaleX", "scaleY", "translationX", "translationY", "clipPathData", "", "Landroidx/compose/ui/graphics/vector/PathNode;", "children", "", "Landroidx/compose/ui/graphics/vector/VectorNode;", "(Ljava/lang/String;FFFFFFFLjava/util/List;Ljava/util/List;)V", "getChildren", "()Ljava/util/List;", "setChildren", "(Ljava/util/List;)V", "getClipPathData", "setClipPathData", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "getPivotX", "()F", "setPivotX", "(F)V", "getPivotY", "setPivotY", "getRotate", "setRotate", "getScaleX", "setScaleX", "getScaleY", "setScaleY", "getTranslationX", "setTranslationX", "getTranslationY", "setTranslationY", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
        /* loaded from: classes.dex */
        public static final class GroupParams {
            private List<VectorNode> children;
            private List<? extends PathNode> clipPathData;
            private String name;
            private float pivotX;
            private float pivotY;
            private float rotate;
            private float scaleX;
            private float scaleY;
            private float translationX;
            private float translationY;

            public GroupParams() {
                this(null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, 1023, null);
            }

            public GroupParams(String name, float rotate, float pivotX, float pivotY, float scaleX, float scaleY, float translationX, float translationY, List<? extends PathNode> clipPathData, List<VectorNode> children) {
                Intrinsics.checkNotNullParameter(name, "name");
                Intrinsics.checkNotNullParameter(clipPathData, "clipPathData");
                Intrinsics.checkNotNullParameter(children, "children");
                this.name = name;
                this.rotate = rotate;
                this.pivotX = pivotX;
                this.pivotY = pivotY;
                this.scaleX = scaleX;
                this.scaleY = scaleY;
                this.translationX = translationX;
                this.translationY = translationY;
                this.clipPathData = clipPathData;
                this.children = children;
            }

            public /* synthetic */ GroupParams(String str, float f, float f2, float f3, float f4, float f5, float f6, float f7, List list, List list2, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? 0.0f : f, (i & 4) != 0 ? 0.0f : f2, (i & 8) != 0 ? 0.0f : f3, (i & 16) != 0 ? 1.0f : f4, (i & 32) == 0 ? f5 : 1.0f, (i & 64) != 0 ? 0.0f : f6, (i & 128) == 0 ? f7 : 0.0f, (i & 256) != 0 ? VectorKt.getEmptyPath() : list, (i & 512) != 0 ? new ArrayList() : list2);
            }

            public final String getName() {
                return this.name;
            }

            public final void setName(String str) {
                Intrinsics.checkNotNullParameter(str, "<set-?>");
                this.name = str;
            }

            public final float getRotate() {
                return this.rotate;
            }

            public final void setRotate(float f) {
                this.rotate = f;
            }

            public final float getPivotX() {
                return this.pivotX;
            }

            public final void setPivotX(float f) {
                this.pivotX = f;
            }

            public final float getPivotY() {
                return this.pivotY;
            }

            public final void setPivotY(float f) {
                this.pivotY = f;
            }

            public final float getScaleX() {
                return this.scaleX;
            }

            public final void setScaleX(float f) {
                this.scaleX = f;
            }

            public final float getScaleY() {
                return this.scaleY;
            }

            public final void setScaleY(float f) {
                this.scaleY = f;
            }

            public final float getTranslationX() {
                return this.translationX;
            }

            public final void setTranslationX(float f) {
                this.translationX = f;
            }

            public final float getTranslationY() {
                return this.translationY;
            }

            public final void setTranslationY(float f) {
                this.translationY = f;
            }

            public final List<PathNode> getClipPathData() {
                return this.clipPathData;
            }

            public final void setClipPathData(List<? extends PathNode> list) {
                Intrinsics.checkNotNullParameter(list, "<set-?>");
                this.clipPathData = list;
            }

            public final List<VectorNode> getChildren() {
                return this.children;
            }

            public final void setChildren(List<VectorNode> list) {
                Intrinsics.checkNotNullParameter(list, "<set-?>");
                this.children = list;
            }
        }
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ImageVector) || !Intrinsics.areEqual(this.name, ((ImageVector) other).name) || !Dp.m5223equalsimpl0(this.defaultWidth, ((ImageVector) other).defaultWidth) || !Dp.m5223equalsimpl0(this.defaultHeight, ((ImageVector) other).defaultHeight)) {
            return false;
        }
        if (this.viewportWidth == ((ImageVector) other).viewportWidth) {
            return ((this.viewportHeight > ((ImageVector) other).viewportHeight ? 1 : (this.viewportHeight == ((ImageVector) other).viewportHeight ? 0 : -1)) == 0) && Intrinsics.areEqual(this.root, ((ImageVector) other).root) && Color.m2950equalsimpl0(this.tintColor, ((ImageVector) other).tintColor) && BlendMode.m2862equalsimpl0(this.tintBlendMode, ((ImageVector) other).tintBlendMode) && this.autoMirror == ((ImageVector) other).autoMirror;
        }
        return false;
    }

    public int hashCode() {
        int result = this.name.hashCode();
        return (((((((((((((((result * 31) + Dp.m5224hashCodeimpl(this.defaultWidth)) * 31) + Dp.m5224hashCodeimpl(this.defaultHeight)) * 31) + Float.hashCode(this.viewportWidth)) * 31) + Float.hashCode(this.viewportHeight)) * 31) + this.root.hashCode()) * 31) + Color.m2956hashCodeimpl(this.tintColor)) * 31) + BlendMode.m2863hashCodeimpl(this.tintBlendMode)) * 31) + Boolean.hashCode(this.autoMirror);
    }
}
