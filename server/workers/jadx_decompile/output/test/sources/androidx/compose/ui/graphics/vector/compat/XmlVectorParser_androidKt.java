package androidx.compose.ui.graphics.vector.compat;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.util.TypedValue;
import androidx.compose.ui.graphics.BlendMode;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.BrushKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.PathFillType;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.StrokeJoin;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.graphics.vector.VectorKt;
import androidx.compose.ui.unit.Dp;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.res.ComplexColorCompat;
import androidx.core.content.res.TypedArrayUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: XmlVectorParser.android.kt */
@Metadata(d1 = {"\u0000\\\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u001a'\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00012\b\b\u0002\u0010\u000f\u001a\u00020\rH\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0010\u0010\u0011\u001a'\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u000e\u001a\u00020\u00012\b\b\u0002\u0010\u000f\u001a\u00020\u0013H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0014\u0010\u0011\u001a\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0002\u001a*\u0010\u0019\u001a\u00020\u001a*\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\f\u0010\u001e\u001a\b\u0018\u00010\u001fR\u00020\u001d2\u0006\u0010 \u001a\u00020!H\u0000\u001a\f\u0010\"\u001a\u00020#*\u00020$H\u0000\u001a2\u0010%\u001a\u00020&*\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\f\u0010\u001e\u001a\b\u0018\u00010\u001fR\u00020\u001d2\u0006\u0010 \u001a\u00020!2\u0006\u0010'\u001a\u00020\u001aH\u0000\u001a<\u0010(\u001a\u00020\u0001*\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020!2\u000e\b\u0002\u0010\u001e\u001a\b\u0018\u00010\u001fR\u00020\u001d2\u0006\u0010'\u001a\u00020\u001a2\u0006\u0010)\u001a\u00020\u0001H\u0000\u001a2\u0010*\u001a\u00020&*\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\f\u0010\u001e\u001a\b\u0018\u00010\u001fR\u00020\u001d2\u0006\u0010 \u001a\u00020!2\u0006\u0010'\u001a\u00020\u001aH\u0000\u001a2\u0010+\u001a\u00020&*\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\f\u0010\u001e\u001a\b\u0018\u00010\u001fR\u00020\u001d2\u0006\u0010 \u001a\u00020!2\u0006\u0010'\u001a\u00020\u001aH\u0000\u001a\f\u0010,\u001a\u00020$*\u00020$H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082D¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006-"}, d2 = {"FILL_TYPE_WINDING", "", "LINECAP_BUTT", "LINECAP_ROUND", "LINECAP_SQUARE", "LINEJOIN_BEVEL", "LINEJOIN_MITER", "LINEJOIN_ROUND", "SHAPE_CLIP_PATH", "", "SHAPE_GROUP", "SHAPE_PATH", "getStrokeLineCap", "Landroidx/compose/ui/graphics/StrokeCap;", "id", "defValue", "getStrokeLineCap-CSYIeUk", "(II)I", "getStrokeLineJoin", "Landroidx/compose/ui/graphics/StrokeJoin;", "getStrokeLineJoin-kLtJ_vA", "obtainBrushFromComplexColor", "Landroidx/compose/ui/graphics/Brush;", "complexColor", "Landroidx/core/content/res/ComplexColorCompat;", "createVectorImageBuilder", "Landroidx/compose/ui/graphics/vector/ImageVector$Builder;", "Landroidx/compose/ui/graphics/vector/compat/AndroidVectorParser;", "res", "Landroid/content/res/Resources;", "theme", "Landroid/content/res/Resources$Theme;", "attrs", "Landroid/util/AttributeSet;", "isAtEnd", "", "Lorg/xmlpull/v1/XmlPullParser;", "parseClipPath", "", "builder", "parseCurrentVectorNode", "nestedGroups", "parseGroup", "parsePath", "seekToStartTag", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class XmlVectorParser_androidKt {
    private static final int FILL_TYPE_WINDING = 0;
    private static final int LINECAP_BUTT = 0;
    private static final int LINECAP_ROUND = 1;
    private static final int LINECAP_SQUARE = 2;
    private static final int LINEJOIN_BEVEL = 2;
    private static final int LINEJOIN_MITER = 0;
    private static final int LINEJOIN_ROUND = 1;
    private static final String SHAPE_CLIP_PATH = "clip-path";
    private static final String SHAPE_GROUP = "group";
    private static final String SHAPE_PATH = "path";

    /* renamed from: getStrokeLineCap-CSYIeUk$default, reason: not valid java name */
    static /* synthetic */ int m3595getStrokeLineCapCSYIeUk$default(int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = StrokeCap.INSTANCE.m3295getButtKaPHkGw();
        }
        return m3594getStrokeLineCapCSYIeUk(i, i2);
    }

    /* renamed from: getStrokeLineCap-CSYIeUk, reason: not valid java name */
    private static final int m3594getStrokeLineCapCSYIeUk(int id, int defValue) {
        switch (id) {
            case 0:
                return StrokeCap.INSTANCE.m3295getButtKaPHkGw();
            case 1:
                return StrokeCap.INSTANCE.m3296getRoundKaPHkGw();
            case 2:
                return StrokeCap.INSTANCE.m3297getSquareKaPHkGw();
            default:
                return defValue;
        }
    }

    /* renamed from: getStrokeLineJoin-kLtJ_vA$default, reason: not valid java name */
    static /* synthetic */ int m3597getStrokeLineJoinkLtJ_vA$default(int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = StrokeJoin.INSTANCE.m3306getMiterLxFBmk8();
        }
        return m3596getStrokeLineJoinkLtJ_vA(i, i2);
    }

    /* renamed from: getStrokeLineJoin-kLtJ_vA, reason: not valid java name */
    private static final int m3596getStrokeLineJoinkLtJ_vA(int id, int defValue) {
        switch (id) {
            case 0:
                return StrokeJoin.INSTANCE.m3306getMiterLxFBmk8();
            case 1:
                return StrokeJoin.INSTANCE.m3307getRoundLxFBmk8();
            case 2:
                return StrokeJoin.INSTANCE.m3305getBevelLxFBmk8();
            default:
                return defValue;
        }
    }

    public static final boolean isAtEnd(XmlPullParser $this$isAtEnd) {
        Intrinsics.checkNotNullParameter($this$isAtEnd, "<this>");
        if ($this$isAtEnd.getEventType() != 1) {
            return $this$isAtEnd.getDepth() < 1 && $this$isAtEnd.getEventType() == 3;
        }
        return true;
    }

    public static /* synthetic */ int parseCurrentVectorNode$default(AndroidVectorParser androidVectorParser, Resources resources, AttributeSet attributeSet, Resources.Theme theme, ImageVector.Builder builder, int i, int i2, Object obj) {
        Resources.Theme theme2;
        if ((i2 & 4) == 0) {
            theme2 = theme;
        } else {
            theme2 = null;
        }
        return parseCurrentVectorNode(androidVectorParser, resources, attributeSet, theme2, builder, i);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static final int parseCurrentVectorNode(AndroidVectorParser $this$parseCurrentVectorNode, Resources res, AttributeSet attrs, Resources.Theme theme, ImageVector.Builder builder, int nestedGroups) {
        Intrinsics.checkNotNullParameter($this$parseCurrentVectorNode, "<this>");
        Intrinsics.checkNotNullParameter(res, "res");
        Intrinsics.checkNotNullParameter(attrs, "attrs");
        Intrinsics.checkNotNullParameter(builder, "builder");
        switch ($this$parseCurrentVectorNode.getXmlParser().getEventType()) {
            case 2:
                String name = $this$parseCurrentVectorNode.getXmlParser().getName();
                if (name != null) {
                    switch (name.hashCode()) {
                        case -1649314686:
                            if (name.equals(SHAPE_CLIP_PATH)) {
                                parseClipPath($this$parseCurrentVectorNode, res, theme, attrs, builder);
                                return nestedGroups + 1;
                            }
                            break;
                        case 3433509:
                            if (name.equals(SHAPE_PATH)) {
                                parsePath($this$parseCurrentVectorNode, res, theme, attrs, builder);
                                break;
                            }
                            break;
                        case 98629247:
                            if (name.equals(SHAPE_GROUP)) {
                                parseGroup($this$parseCurrentVectorNode, res, theme, attrs, builder);
                                break;
                            }
                            break;
                    }
                }
                return nestedGroups;
            case 3:
                if (Intrinsics.areEqual(SHAPE_GROUP, $this$parseCurrentVectorNode.getXmlParser().getName())) {
                    int i = nestedGroups + 1;
                    for (int i2 = 0; i2 < i; i2++) {
                        builder.clearGroup();
                    }
                    return 0;
                }
                return nestedGroups;
            default:
                return nestedGroups;
        }
    }

    public static final XmlPullParser seekToStartTag(XmlPullParser $this$seekToStartTag) throws XmlPullParserException {
        Intrinsics.checkNotNullParameter($this$seekToStartTag, "<this>");
        int type = $this$seekToStartTag.next();
        while (type != 2 && type != 1) {
            type = $this$seekToStartTag.next();
        }
        if (type != 2) {
            throw new XmlPullParserException("No start tag found");
        }
        return $this$seekToStartTag;
    }

    public static final ImageVector.Builder createVectorImageBuilder(AndroidVectorParser $this$createVectorImageBuilder, Resources res, Resources.Theme theme, AttributeSet attrs) {
        long tintColor;
        int tintBlendMode;
        Intrinsics.checkNotNullParameter($this$createVectorImageBuilder, "<this>");
        Intrinsics.checkNotNullParameter(res, "res");
        Intrinsics.checkNotNullParameter(attrs, "attrs");
        TypedArray vectorAttrs = $this$createVectorImageBuilder.obtainAttributes(res, theme, attrs, AndroidVectorResources.INSTANCE.getSTYLEABLE_VECTOR_DRAWABLE_TYPE_ARRAY());
        boolean autoMirror = $this$createVectorImageBuilder.getNamedBoolean(vectorAttrs, "autoMirrored", AndroidVectorResources.INSTANCE.getSTYLEABLE_VECTOR_DRAWABLE_AUTO_MIRRORED(), false);
        float viewportWidth = $this$createVectorImageBuilder.getNamedFloat(vectorAttrs, "viewportWidth", AndroidVectorResources.INSTANCE.getSTYLEABLE_VECTOR_DRAWABLE_VIEWPORT_WIDTH(), 0.0f);
        float viewportHeight = $this$createVectorImageBuilder.getNamedFloat(vectorAttrs, "viewportHeight", AndroidVectorResources.INSTANCE.getSTYLEABLE_VECTOR_DRAWABLE_VIEWPORT_HEIGHT(), 0.0f);
        if (viewportWidth <= 0.0f) {
            throw new XmlPullParserException(vectorAttrs.getPositionDescription() + "<VectorGraphic> tag requires viewportWidth > 0");
        }
        if (viewportHeight <= 0.0f) {
            throw new XmlPullParserException(vectorAttrs.getPositionDescription() + "<VectorGraphic> tag requires viewportHeight > 0");
        }
        float defaultWidth = $this$createVectorImageBuilder.getDimension(vectorAttrs, AndroidVectorResources.INSTANCE.getSTYLEABLE_VECTOR_DRAWABLE_WIDTH(), 0.0f);
        float defaultHeight = $this$createVectorImageBuilder.getDimension(vectorAttrs, AndroidVectorResources.INSTANCE.getSTYLEABLE_VECTOR_DRAWABLE_HEIGHT(), 0.0f);
        if (vectorAttrs.hasValue(AndroidVectorResources.INSTANCE.getSTYLEABLE_VECTOR_DRAWABLE_TINT())) {
            TypedValue value = new TypedValue();
            vectorAttrs.getValue(AndroidVectorResources.INSTANCE.getSTYLEABLE_VECTOR_DRAWABLE_TINT(), value);
            if (value.type == 2) {
                tintColor = Color.INSTANCE.m2985getUnspecified0d7_KjU();
            } else {
                ColorStateList tintColorStateList = $this$createVectorImageBuilder.getNamedColorStateList(vectorAttrs, theme, "tint", AndroidVectorResources.INSTANCE.getSTYLEABLE_VECTOR_DRAWABLE_TINT());
                if (tintColorStateList != null) {
                    tintColor = ColorKt.Color(tintColorStateList.getDefaultColor());
                } else {
                    tintColor = Color.INSTANCE.m2985getUnspecified0d7_KjU();
                }
            }
        } else {
            tintColor = Color.INSTANCE.m2985getUnspecified0d7_KjU();
        }
        int blendModeValue = $this$createVectorImageBuilder.getInt(vectorAttrs, AndroidVectorResources.INSTANCE.getSTYLEABLE_VECTOR_DRAWABLE_TINT_MODE(), -1);
        if (blendModeValue != -1) {
            switch (blendModeValue) {
                case 3:
                    tintBlendMode = BlendMode.INSTANCE.m2893getSrcOver0nO6VwU();
                    break;
                case 5:
                    tintBlendMode = BlendMode.INSTANCE.m2891getSrcIn0nO6VwU();
                    break;
                case 9:
                    tintBlendMode = BlendMode.INSTANCE.m2890getSrcAtop0nO6VwU();
                    break;
                case 14:
                    tintBlendMode = BlendMode.INSTANCE.m2882getModulate0nO6VwU();
                    break;
                case 15:
                    tintBlendMode = BlendMode.INSTANCE.m2887getScreen0nO6VwU();
                    break;
                case 16:
                    tintBlendMode = BlendMode.INSTANCE.m2885getPlus0nO6VwU();
                    break;
                default:
                    tintBlendMode = BlendMode.INSTANCE.m2891getSrcIn0nO6VwU();
                    break;
            }
        } else {
            tintBlendMode = BlendMode.INSTANCE.m2891getSrcIn0nO6VwU();
        }
        float $this$dp$iv = defaultWidth / res.getDisplayMetrics().density;
        float defaultWidthDp = Dp.m5218constructorimpl($this$dp$iv);
        float $this$dp$iv2 = defaultHeight / res.getDisplayMetrics().density;
        float defaultHeightDp = Dp.m5218constructorimpl($this$dp$iv2);
        vectorAttrs.recycle();
        return new ImageVector.Builder(null, defaultWidthDp, defaultHeightDp, viewportWidth, viewportHeight, tintColor, tintBlendMode, autoMirror, 1, null);
    }

    public static final void parsePath(AndroidVectorParser $this$parsePath, Resources res, Resources.Theme theme, AttributeSet attrs, ImageVector.Builder builder) throws IllegalArgumentException {
        String name;
        Intrinsics.checkNotNullParameter($this$parsePath, "<this>");
        Intrinsics.checkNotNullParameter(res, "res");
        Intrinsics.checkNotNullParameter(attrs, "attrs");
        Intrinsics.checkNotNullParameter(builder, "builder");
        TypedArray a = $this$parsePath.obtainAttributes(res, theme, attrs, AndroidVectorResources.INSTANCE.getSTYLEABLE_VECTOR_DRAWABLE_PATH());
        boolean hasPathData = TypedArrayUtils.hasAttribute($this$parsePath.getXmlParser(), "pathData");
        if (!hasPathData) {
            throw new IllegalArgumentException("No path data available");
        }
        String string = $this$parsePath.getString(a, AndroidVectorResources.INSTANCE.getSTYLEABLE_VECTOR_DRAWABLE_PATH_NAME());
        if (string != null) {
            name = string;
        } else {
            name = "";
        }
        String pathStr = $this$parsePath.getString(a, AndroidVectorResources.INSTANCE.getSTYLEABLE_VECTOR_DRAWABLE_PATH_PATH_DATA());
        List pathData = VectorKt.addPathNodes(pathStr);
        ComplexColorCompat fillColor = $this$parsePath.getNamedComplexColor(a, theme, "fillColor", AndroidVectorResources.INSTANCE.getSTYLEABLE_VECTOR_DRAWABLE_PATH_FILL_COLOR(), 0);
        float fillAlpha = $this$parsePath.getNamedFloat(a, "fillAlpha", AndroidVectorResources.INSTANCE.getSTYLEABLE_VECTOR_DRAWABLE_PATH_FILL_ALPHA(), 1.0f);
        int lineCap = $this$parsePath.getNamedInt(a, "strokeLineCap", AndroidVectorResources.INSTANCE.getSTYLEABLE_VECTOR_DRAWABLE_PATH_STROKE_LINE_CAP(), -1);
        int strokeLineCap = m3594getStrokeLineCapCSYIeUk(lineCap, StrokeCap.INSTANCE.m3295getButtKaPHkGw());
        int lineJoin = $this$parsePath.getNamedInt(a, "strokeLineJoin", AndroidVectorResources.INSTANCE.getSTYLEABLE_VECTOR_DRAWABLE_PATH_STROKE_LINE_JOIN(), -1);
        int strokeLineJoin = m3596getStrokeLineJoinkLtJ_vA(lineJoin, StrokeJoin.INSTANCE.m3305getBevelLxFBmk8());
        float strokeMiterLimit = $this$parsePath.getNamedFloat(a, "strokeMiterLimit", AndroidVectorResources.INSTANCE.getSTYLEABLE_VECTOR_DRAWABLE_PATH_STROKE_MITER_LIMIT(), 1.0f);
        ComplexColorCompat strokeColor = $this$parsePath.getNamedComplexColor(a, theme, "strokeColor", AndroidVectorResources.INSTANCE.getSTYLEABLE_VECTOR_DRAWABLE_PATH_STROKE_COLOR(), 0);
        float strokeAlpha = $this$parsePath.getNamedFloat(a, "strokeAlpha", AndroidVectorResources.INSTANCE.getSTYLEABLE_VECTOR_DRAWABLE_PATH_STROKE_ALPHA(), 1.0f);
        float strokeLineWidth = $this$parsePath.getNamedFloat(a, "strokeWidth", AndroidVectorResources.INSTANCE.getSTYLEABLE_VECTOR_DRAWABLE_PATH_STROKE_WIDTH(), 1.0f);
        float trimPathEnd = $this$parsePath.getNamedFloat(a, "trimPathEnd", AndroidVectorResources.INSTANCE.getSTYLEABLE_VECTOR_DRAWABLE_PATH_TRIM_PATH_END(), 1.0f);
        float trimPathOffset = $this$parsePath.getNamedFloat(a, "trimPathOffset", AndroidVectorResources.INSTANCE.getSTYLEABLE_VECTOR_DRAWABLE_PATH_TRIM_PATH_OFFSET(), 0.0f);
        float trimPathStart = $this$parsePath.getNamedFloat(a, "trimPathStart", AndroidVectorResources.INSTANCE.getSTYLEABLE_VECTOR_DRAWABLE_PATH_TRIM_PATH_START(), 0.0f);
        int fillRule = $this$parsePath.getNamedInt(a, "fillType", AndroidVectorResources.INSTANCE.getSTYLEABLE_VECTOR_DRAWABLE_PATH_TRIM_PATH_FILLTYPE(), FILL_TYPE_WINDING);
        a.recycle();
        Brush fillBrush = obtainBrushFromComplexColor(fillColor);
        Brush strokeBrush = obtainBrushFromComplexColor(strokeColor);
        PathFillType.Companion companion = PathFillType.INSTANCE;
        int lineJoin2 = fillRule == 0 ? companion.m3226getNonZeroRgk1Os() : companion.m3225getEvenOddRgk1Os();
        builder.m3574addPathoIyEayM(pathData, lineJoin2, name, fillBrush, fillAlpha, strokeBrush, strokeAlpha, strokeLineWidth, strokeLineCap, strokeLineJoin, strokeMiterLimit, trimPathStart, trimPathEnd, trimPathOffset);
    }

    private static final Brush obtainBrushFromComplexColor(ComplexColorCompat complexColor) {
        if (!complexColor.willDraw()) {
            return null;
        }
        Shader shader = complexColor.getShader();
        if (shader != null) {
            return BrushKt.ShaderBrush(shader);
        }
        return new SolidColor(ColorKt.Color(complexColor.getColor()), null);
    }

    public static final void parseClipPath(AndroidVectorParser $this$parseClipPath, Resources res, Resources.Theme theme, AttributeSet attrs, ImageVector.Builder builder) {
        String name;
        Intrinsics.checkNotNullParameter($this$parseClipPath, "<this>");
        Intrinsics.checkNotNullParameter(res, "res");
        Intrinsics.checkNotNullParameter(attrs, "attrs");
        Intrinsics.checkNotNullParameter(builder, "builder");
        TypedArray a = $this$parseClipPath.obtainAttributes(res, theme, attrs, AndroidVectorResources.INSTANCE.getSTYLEABLE_VECTOR_DRAWABLE_CLIP_PATH());
        String string = $this$parseClipPath.getString(a, AndroidVectorResources.INSTANCE.getSTYLEABLE_VECTOR_DRAWABLE_CLIP_PATH_NAME());
        if (string != null) {
            name = string;
        } else {
            name = "";
        }
        List pathData = VectorKt.addPathNodes($this$parseClipPath.getString(a, AndroidVectorResources.INSTANCE.getSTYLEABLE_VECTOR_DRAWABLE_CLIP_PATH_PATH_DATA()));
        a.recycle();
        builder.addGroup((r20 & 1) != 0 ? "" : name, (r20 & 2) != 0 ? 0.0f : 0.0f, (r20 & 4) != 0 ? 0.0f : 0.0f, (r20 & 8) != 0 ? 0.0f : 0.0f, (r20 & 16) != 0 ? 1.0f : 0.0f, (r20 & 32) == 0 ? 0.0f : 1.0f, (r20 & 64) != 0 ? 0.0f : 0.0f, (r20 & 128) == 0 ? 0.0f : 0.0f, (r20 & 256) != 0 ? VectorKt.getEmptyPath() : pathData);
    }

    public static final void parseGroup(AndroidVectorParser $this$parseGroup, Resources res, Resources.Theme theme, AttributeSet attrs, ImageVector.Builder builder) {
        String name;
        Intrinsics.checkNotNullParameter($this$parseGroup, "<this>");
        Intrinsics.checkNotNullParameter(res, "res");
        Intrinsics.checkNotNullParameter(attrs, "attrs");
        Intrinsics.checkNotNullParameter(builder, "builder");
        TypedArray a = $this$parseGroup.obtainAttributes(res, theme, attrs, AndroidVectorResources.INSTANCE.getSTYLEABLE_VECTOR_DRAWABLE_GROUP());
        float rotate = $this$parseGroup.getNamedFloat(a, "rotation", AndroidVectorResources.INSTANCE.getSTYLEABLE_VECTOR_DRAWABLE_GROUP_ROTATION(), 0.0f);
        float pivotX = $this$parseGroup.getFloat(a, AndroidVectorResources.INSTANCE.getSTYLEABLE_VECTOR_DRAWABLE_GROUP_PIVOT_X(), 0.0f);
        float pivotY = $this$parseGroup.getFloat(a, AndroidVectorResources.INSTANCE.getSTYLEABLE_VECTOR_DRAWABLE_GROUP_PIVOT_Y(), 0.0f);
        float scaleX = $this$parseGroup.getNamedFloat(a, "scaleX", AndroidVectorResources.INSTANCE.getSTYLEABLE_VECTOR_DRAWABLE_GROUP_SCALE_X(), 1.0f);
        float scaleY = $this$parseGroup.getNamedFloat(a, "scaleY", AndroidVectorResources.INSTANCE.getSTYLEABLE_VECTOR_DRAWABLE_GROUP_SCALE_Y(), 1.0f);
        float translateX = $this$parseGroup.getNamedFloat(a, "translateX", AndroidVectorResources.INSTANCE.getSTYLEABLE_VECTOR_DRAWABLE_GROUP_TRANSLATE_X(), 0.0f);
        float translateY = $this$parseGroup.getNamedFloat(a, "translateY", AndroidVectorResources.INSTANCE.getSTYLEABLE_VECTOR_DRAWABLE_GROUP_TRANSLATE_Y(), 0.0f);
        String string = $this$parseGroup.getString(a, AndroidVectorResources.INSTANCE.getSTYLEABLE_VECTOR_DRAWABLE_GROUP_NAME());
        if (string != null) {
            name = string;
        } else {
            name = "";
        }
        a.recycle();
        builder.addGroup(name, rotate, pivotX, pivotY, scaleX, scaleY, translateX, translateY, VectorKt.getEmptyPath());
    }
}
