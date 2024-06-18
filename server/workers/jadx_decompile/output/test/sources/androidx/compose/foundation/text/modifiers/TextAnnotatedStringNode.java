package androidx.compose.foundation.text.modifiers;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.ColorProducer;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.layout.AlignmentLine;
import androidx.compose.ui.layout.AlignmentLineKt;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.DrawModifierNode;
import androidx.compose.ui.node.DrawModifierNodeKt;
import androidx.compose.ui.node.LayoutModifierNode;
import androidx.compose.ui.node.LayoutModifierNodeKt;
import androidx.compose.ui.node.SemanticsModifierNode;
import androidx.compose.ui.node.SemanticsModifierNodeKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.Placeholder;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntSize;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* compiled from: TextAnnotatedStringNode.kt */
@Metadata(d1 = {"\u0000Â\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B°\u0001\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0016\b\u0002\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e\u0018\u00010\f\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0012\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0014\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0014\u0012\u0016\b\u0002\u0010\u0016\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\u0018\u0018\u00010\u0017\u0012\u001e\b\u0002\u0010\u001a\u001a\u0018\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u001b0\u0017\u0012\u0004\u0012\u00020\u000e\u0018\u00010\f\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001fø\u0001\u0000¢\u0006\u0002\u0010 J&\u0010,\u001a\u00020\u000e2\u0006\u0010-\u001a\u00020\u00122\u0006\u0010.\u001a\u00020\u00122\u0006\u0010/\u001a\u00020\u00122\u0006\u00100\u001a\u00020\u0012J\u000e\u00101\u001a\u00020\u000e2\u0006\u00102\u001a\u000203J\u0010\u0010'\u001a\u00020\"2\u0006\u00104\u001a\u000205H\u0002J\u001e\u00106\u001a\u00020\u00142\u0006\u00107\u001a\u0002082\u0006\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020\u0014J\u001e\u0010<\u001a\u00020\u00142\u0006\u00107\u001a\u0002082\u0006\u00109\u001a\u00020:2\u0006\u0010=\u001a\u00020\u0014J+\u0010>\u001a\u00020?2\u0006\u0010@\u001a\u00020A2\u0006\u00109\u001a\u00020B2\u0006\u0010C\u001a\u00020Dø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bE\u0010FJ\u001e\u0010G\u001a\u00020\u00142\u0006\u00107\u001a\u0002082\u0006\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020\u0014J\u001e\u0010H\u001a\u00020\u00142\u0006\u00107\u001a\u0002082\u0006\u00109\u001a\u00020:2\u0006\u0010=\u001a\u00020\u0014JD\u0010I\u001a\u00020\u00122\u0014\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e\u0018\u00010\f2\u001c\u0010\u001a\u001a\u0018\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u001b0\u0017\u0012\u0004\u0012\u00020\u000e\u0018\u00010\f2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dJ\u0018\u0010J\u001a\u00020\u00122\b\u0010K\u001a\u0004\u0018\u00010\u001f2\u0006\u0010\u0007\u001a\u00020\bJY\u0010L\u001a\u00020\u00122\u0006\u0010\u0007\u001a\u00020\b2\u0014\u0010\u0016\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\u0018\u0018\u00010\u00172\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u0010ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bM\u0010NJ\u000e\u0010O\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u0006J\f\u0010P\u001a\u00020\u000e*\u00020QH\u0016J\f\u0010R\u001a\u00020\u000e*\u000203H\u0016J\u001c\u0010S\u001a\u00020\u0014*\u0002082\u0006\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020\u0014H\u0016J\u001c\u0010T\u001a\u00020\u0014*\u0002082\u0006\u00109\u001a\u00020:2\u0006\u0010=\u001a\u00020\u0014H\u0016J)\u0010U\u001a\u00020?*\u00020A2\u0006\u00109\u001a\u00020B2\u0006\u0010C\u001a\u00020DH\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bV\u0010FJ\u001c\u0010W\u001a\u00020\u0014*\u0002082\u0006\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020\u0014H\u0016J\u001c\u0010X\u001a\u00020\u0014*\u0002082\u0006\u00109\u001a\u00020:2\u0006\u0010=\u001a\u00020\u0014H\u0016R\u0010\u0010!\u001a\u0004\u0018\u00010\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010#\u001a\u0010\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020\u0014\u0018\u00010$X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010&\u001a\u00020\"8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b'\u0010(R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010\u001a\u001a\u0018\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u001b0\u0017\u0012\u0004\u0012\u00020\u000e\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0019\u0010\u000f\u001a\u00020\u0010X\u0082\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010)R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0016\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\u0018\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010*\u001a\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0+\u0012\u0004\u0012\u00020\u0012\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006Y"}, d2 = {"Landroidx/compose/foundation/text/modifiers/TextAnnotatedStringNode;", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/node/LayoutModifierNode;", "Landroidx/compose/ui/node/DrawModifierNode;", "Landroidx/compose/ui/node/SemanticsModifierNode;", "text", "Landroidx/compose/ui/text/AnnotatedString;", "style", "Landroidx/compose/ui/text/TextStyle;", "fontFamilyResolver", "Landroidx/compose/ui/text/font/FontFamily$Resolver;", "onTextLayout", "Lkotlin/Function1;", "Landroidx/compose/ui/text/TextLayoutResult;", "", "overflow", "Landroidx/compose/ui/text/style/TextOverflow;", "softWrap", "", "maxLines", "", "minLines", "placeholders", "", "Landroidx/compose/ui/text/AnnotatedString$Range;", "Landroidx/compose/ui/text/Placeholder;", "onPlaceholderLayout", "Landroidx/compose/ui/geometry/Rect;", "selectionController", "Landroidx/compose/foundation/text/modifiers/SelectionController;", "overrideColor", "Landroidx/compose/ui/graphics/ColorProducer;", "(Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/font/FontFamily$Resolver;Lkotlin/jvm/functions/Function1;IZIILjava/util/List;Lkotlin/jvm/functions/Function1;Landroidx/compose/foundation/text/modifiers/SelectionController;Landroidx/compose/ui/graphics/ColorProducer;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "_layoutCache", "Landroidx/compose/foundation/text/modifiers/MultiParagraphLayoutCache;", "baselineCache", "", "Landroidx/compose/ui/layout/AlignmentLine;", "layoutCache", "getLayoutCache", "()Landroidx/compose/foundation/text/modifiers/MultiParagraphLayoutCache;", "I", "semanticsTextLayoutResult", "", "doInvalidations", "drawChanged", "textChanged", "layoutChanged", "callbacksChanged", "drawNonExtension", "contentDrawScope", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "density", "Landroidx/compose/ui/unit/Density;", "maxIntrinsicHeightNonExtension", "intrinsicMeasureScope", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "measurable", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "width", "maxIntrinsicWidthNonExtension", "height", "measureNonExtension", "Landroidx/compose/ui/layout/MeasureResult;", "measureScope", "Landroidx/compose/ui/layout/MeasureScope;", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measureNonExtension-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "minIntrinsicHeightNonExtension", "minIntrinsicWidthNonExtension", "updateCallbacks", "updateDraw", "color", "updateLayoutRelatedArgs", "updateLayoutRelatedArgs-MPT68mk", "(Landroidx/compose/ui/text/TextStyle;Ljava/util/List;IIZLandroidx/compose/ui/text/font/FontFamily$Resolver;I)Z", "updateText", "applySemantics", "Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;", "draw", "maxIntrinsicHeight", "maxIntrinsicWidth", "measure", "measure-3p2s80s", "minIntrinsicHeight", "minIntrinsicWidth", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class TextAnnotatedStringNode extends Modifier.Node implements LayoutModifierNode, DrawModifierNode, SemanticsModifierNode {
    private MultiParagraphLayoutCache _layoutCache;
    private Map<AlignmentLine, Integer> baselineCache;
    private FontFamily.Resolver fontFamilyResolver;
    private int maxLines;
    private int minLines;
    private Function1<? super List<Rect>, Unit> onPlaceholderLayout;
    private Function1<? super TextLayoutResult, Unit> onTextLayout;
    private int overflow;
    private ColorProducer overrideColor;
    private List<AnnotatedString.Range<Placeholder>> placeholders;
    private SelectionController selectionController;
    private Function1<? super List<TextLayoutResult>, Boolean> semanticsTextLayoutResult;
    private boolean softWrap;
    private TextStyle style;
    private AnnotatedString text;

    public /* synthetic */ TextAnnotatedStringNode(AnnotatedString annotatedString, TextStyle textStyle, FontFamily.Resolver resolver, Function1 function1, int i, boolean z, int i2, int i3, List list, Function1 function12, SelectionController selectionController, ColorProducer colorProducer, DefaultConstructorMarker defaultConstructorMarker) {
        this(annotatedString, textStyle, resolver, function1, i, z, i2, i3, list, function12, selectionController, colorProducer);
    }

    public /* synthetic */ TextAnnotatedStringNode(AnnotatedString annotatedString, TextStyle textStyle, FontFamily.Resolver resolver, Function1 function1, int i, boolean z, int i2, int i3, List list, Function1 function12, SelectionController selectionController, ColorProducer colorProducer, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(annotatedString, textStyle, resolver, (i4 & 8) != 0 ? null : function1, (i4 & 16) != 0 ? TextOverflow.INSTANCE.m5137getClipgIe3tQ8() : i, (i4 & 32) != 0 ? true : z, (i4 & 64) != 0 ? Integer.MAX_VALUE : i2, (i4 & 128) != 0 ? 1 : i3, (i4 & 256) != 0 ? null : list, (i4 & 512) != 0 ? null : function12, (i4 & 1024) != 0 ? null : selectionController, (i4 & 2048) != 0 ? null : colorProducer, null);
    }

    private TextAnnotatedStringNode(AnnotatedString text, TextStyle style, FontFamily.Resolver fontFamilyResolver, Function1<? super TextLayoutResult, Unit> function1, int overflow, boolean softWrap, int maxLines, int minLines, List<AnnotatedString.Range<Placeholder>> list, Function1<? super List<Rect>, Unit> function12, SelectionController selectionController, ColorProducer overrideColor) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(style, "style");
        Intrinsics.checkNotNullParameter(fontFamilyResolver, "fontFamilyResolver");
        this.text = text;
        this.style = style;
        this.fontFamilyResolver = fontFamilyResolver;
        this.onTextLayout = function1;
        this.overflow = overflow;
        this.softWrap = softWrap;
        this.maxLines = maxLines;
        this.minLines = minLines;
        this.placeholders = list;
        this.onPlaceholderLayout = function12;
        this.selectionController = selectionController;
        this.overrideColor = overrideColor;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final MultiParagraphLayoutCache getLayoutCache() {
        if (this._layoutCache == null) {
            this._layoutCache = new MultiParagraphLayoutCache(this.text, this.style, this.fontFamilyResolver, this.overflow, this.softWrap, this.maxLines, this.minLines, this.placeholders, null);
        }
        MultiParagraphLayoutCache multiParagraphLayoutCache = this._layoutCache;
        Intrinsics.checkNotNull(multiParagraphLayoutCache);
        return multiParagraphLayoutCache;
    }

    private final MultiParagraphLayoutCache getLayoutCache(Density density) {
        MultiParagraphLayoutCache it = getLayoutCache();
        it.setDensity$foundation_release(density);
        return it;
    }

    public final boolean updateDraw(ColorProducer color, TextStyle style) {
        Intrinsics.checkNotNullParameter(style, "style");
        boolean changed = false;
        if (!Intrinsics.areEqual(color, this.overrideColor)) {
            changed = true;
        }
        this.overrideColor = color;
        boolean changed2 = changed || !style.hasSameDrawAffectingAttributes(this.style);
        return changed2;
    }

    public final boolean updateText(AnnotatedString text) {
        Intrinsics.checkNotNullParameter(text, "text");
        if (Intrinsics.areEqual(this.text, text)) {
            return false;
        }
        this.text = text;
        return true;
    }

    /* renamed from: updateLayoutRelatedArgs-MPT68mk, reason: not valid java name */
    public final boolean m871updateLayoutRelatedArgsMPT68mk(TextStyle style, List<AnnotatedString.Range<Placeholder>> placeholders, int minLines, int maxLines, boolean softWrap, FontFamily.Resolver fontFamilyResolver, int overflow) {
        Intrinsics.checkNotNullParameter(style, "style");
        Intrinsics.checkNotNullParameter(fontFamilyResolver, "fontFamilyResolver");
        boolean changed = !this.style.hasSameLayoutAffectingAttributes(style);
        this.style = style;
        if (!Intrinsics.areEqual(this.placeholders, placeholders)) {
            this.placeholders = placeholders;
            changed = true;
        }
        if (this.minLines != minLines) {
            this.minLines = minLines;
            changed = true;
        }
        if (this.maxLines != maxLines) {
            this.maxLines = maxLines;
            changed = true;
        }
        if (this.softWrap != softWrap) {
            this.softWrap = softWrap;
            changed = true;
        }
        if (!Intrinsics.areEqual(this.fontFamilyResolver, fontFamilyResolver)) {
            this.fontFamilyResolver = fontFamilyResolver;
            changed = true;
        }
        if (!TextOverflow.m5130equalsimpl0(this.overflow, overflow)) {
            this.overflow = overflow;
            return true;
        }
        return changed;
    }

    public final boolean updateCallbacks(Function1<? super TextLayoutResult, Unit> onTextLayout, Function1<? super List<Rect>, Unit> onPlaceholderLayout, SelectionController selectionController) {
        boolean changed = false;
        if (!Intrinsics.areEqual(this.onTextLayout, onTextLayout)) {
            this.onTextLayout = onTextLayout;
            changed = true;
        }
        if (!Intrinsics.areEqual(this.onPlaceholderLayout, onPlaceholderLayout)) {
            this.onPlaceholderLayout = onPlaceholderLayout;
            changed = true;
        }
        if (!Intrinsics.areEqual(this.selectionController, selectionController)) {
            this.selectionController = selectionController;
            return true;
        }
        return changed;
    }

    public final void doInvalidations(boolean drawChanged, boolean textChanged, boolean layoutChanged, boolean callbacksChanged) {
        if (textChanged) {
            SemanticsModifierNodeKt.invalidateSemantics(this);
        }
        if (textChanged || layoutChanged || callbacksChanged) {
            getLayoutCache().m853updateZNqEYIc(this.text, this.style, this.fontFamilyResolver, this.overflow, this.softWrap, this.maxLines, this.minLines, this.placeholders);
            LayoutModifierNodeKt.invalidateMeasurement(this);
            DrawModifierNodeKt.invalidateDraw(this);
        }
        if (drawChanged) {
            DrawModifierNodeKt.invalidateDraw(this);
        }
    }

    @Override // androidx.compose.ui.node.SemanticsModifierNode
    public void applySemantics(SemanticsPropertyReceiver $this$applySemantics) {
        Intrinsics.checkNotNullParameter($this$applySemantics, "<this>");
        Function1 localSemanticsTextLayoutResult = this.semanticsTextLayoutResult;
        if (localSemanticsTextLayoutResult == null) {
            localSemanticsTextLayoutResult = new Function1<List<TextLayoutResult>, Boolean>() { // from class: androidx.compose.foundation.text.modifiers.TextAnnotatedStringNode$applySemantics$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Boolean invoke(List<TextLayoutResult> textLayoutResult) {
                    MultiParagraphLayoutCache layoutCache;
                    Intrinsics.checkNotNullParameter(textLayoutResult, "textLayoutResult");
                    layoutCache = TextAnnotatedStringNode.this.getLayoutCache();
                    TextLayoutResult layout = layoutCache.getLayoutCache();
                    if (layout != null) {
                        textLayoutResult.add(layout);
                    } else {
                        layout = null;
                    }
                    return Boolean.valueOf(layout != null);
                }
            };
            this.semanticsTextLayoutResult = localSemanticsTextLayoutResult;
        }
        SemanticsPropertiesKt.setText($this$applySemantics, this.text);
        SemanticsPropertiesKt.getTextLayoutResult$default($this$applySemantics, null, localSemanticsTextLayoutResult, 1, null);
    }

    /* renamed from: measureNonExtension-3p2s80s, reason: not valid java name */
    public final MeasureResult m870measureNonExtension3p2s80s(MeasureScope measureScope, Measurable measurable, long constraints) {
        Intrinsics.checkNotNullParameter(measureScope, "measureScope");
        Intrinsics.checkNotNullParameter(measurable, "measurable");
        return mo241measure3p2s80s(measureScope, measurable, constraints);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    /* renamed from: measure-3p2s80s */
    public MeasureResult mo241measure3p2s80s(MeasureScope measure, Measurable measurable, long constraints) {
        Intrinsics.checkNotNullParameter(measure, "$this$measure");
        Intrinsics.checkNotNullParameter(measurable, "measurable");
        MultiParagraphLayoutCache layoutCache = getLayoutCache(measure);
        boolean didChangeLayout = layoutCache.m852layoutWithConstraintsK40F9xA(constraints, measure.getLayoutDirection());
        TextLayoutResult textLayoutResult = layoutCache.getTextLayoutResult();
        textLayoutResult.getMultiParagraph().getIntrinsics().getHasStaleResolvedFonts();
        if (didChangeLayout) {
            LayoutModifierNodeKt.invalidateLayer(this);
            Function1<? super TextLayoutResult, Unit> function1 = this.onTextLayout;
            if (function1 != null) {
                function1.invoke(textLayoutResult);
            }
            SelectionController selectionController = this.selectionController;
            if (selectionController != null) {
                selectionController.updateTextLayout(textLayoutResult);
            }
            this.baselineCache = MapsKt.mapOf(TuplesKt.to(AlignmentLineKt.getFirstBaseline(), Integer.valueOf(MathKt.roundToInt(textLayoutResult.getFirstBaseline()))), TuplesKt.to(AlignmentLineKt.getLastBaseline(), Integer.valueOf(MathKt.roundToInt(textLayoutResult.getLastBaseline()))));
        }
        Function1<? super List<Rect>, Unit> function12 = this.onPlaceholderLayout;
        if (function12 != null) {
            function12.invoke(textLayoutResult.getPlaceholderRects());
        }
        final Placeable placeable = measurable.mo4186measureBRTryo0(Constraints.INSTANCE.m5182fixedJhjzzOo(IntSize.m5378getWidthimpl(textLayoutResult.getSize()), IntSize.m5377getHeightimpl(textLayoutResult.getSize())));
        int m5378getWidthimpl = IntSize.m5378getWidthimpl(textLayoutResult.getSize());
        int m5377getHeightimpl = IntSize.m5377getHeightimpl(textLayoutResult.getSize());
        Map<AlignmentLine, Integer> map = this.baselineCache;
        Intrinsics.checkNotNull(map);
        return measure.layout(m5378getWidthimpl, m5377getHeightimpl, map, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.text.modifiers.TextAnnotatedStringNode$measure$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                invoke2(placementScope);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Placeable.PlacementScope layout) {
                Intrinsics.checkNotNullParameter(layout, "$this$layout");
                Placeable.PlacementScope.place$default(layout, Placeable.this, 0, 0, 0.0f, 4, null);
            }
        });
    }

    public final int minIntrinsicWidthNonExtension(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable measurable, int height) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "intrinsicMeasureScope");
        Intrinsics.checkNotNullParameter(measurable, "measurable");
        return minIntrinsicWidth(intrinsicMeasureScope, measurable, height);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int minIntrinsicWidth(IntrinsicMeasureScope $this$minIntrinsicWidth, IntrinsicMeasurable measurable, int height) {
        Intrinsics.checkNotNullParameter($this$minIntrinsicWidth, "<this>");
        Intrinsics.checkNotNullParameter(measurable, "measurable");
        return getLayoutCache($this$minIntrinsicWidth).minIntrinsicWidth($this$minIntrinsicWidth.getLayoutDirection());
    }

    public final int minIntrinsicHeightNonExtension(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable measurable, int width) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "intrinsicMeasureScope");
        Intrinsics.checkNotNullParameter(measurable, "measurable");
        return minIntrinsicHeight(intrinsicMeasureScope, measurable, width);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int minIntrinsicHeight(IntrinsicMeasureScope $this$minIntrinsicHeight, IntrinsicMeasurable measurable, int width) {
        Intrinsics.checkNotNullParameter($this$minIntrinsicHeight, "<this>");
        Intrinsics.checkNotNullParameter(measurable, "measurable");
        return getLayoutCache($this$minIntrinsicHeight).intrinsicHeight(width, $this$minIntrinsicHeight.getLayoutDirection());
    }

    public final int maxIntrinsicWidthNonExtension(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable measurable, int height) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "intrinsicMeasureScope");
        Intrinsics.checkNotNullParameter(measurable, "measurable");
        return maxIntrinsicWidth(intrinsicMeasureScope, measurable, height);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int maxIntrinsicWidth(IntrinsicMeasureScope $this$maxIntrinsicWidth, IntrinsicMeasurable measurable, int height) {
        Intrinsics.checkNotNullParameter($this$maxIntrinsicWidth, "<this>");
        Intrinsics.checkNotNullParameter(measurable, "measurable");
        return getLayoutCache($this$maxIntrinsicWidth).maxIntrinsicWidth($this$maxIntrinsicWidth.getLayoutDirection());
    }

    public final int maxIntrinsicHeightNonExtension(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable measurable, int width) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "intrinsicMeasureScope");
        Intrinsics.checkNotNullParameter(measurable, "measurable");
        return maxIntrinsicHeight(intrinsicMeasureScope, measurable, width);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int maxIntrinsicHeight(IntrinsicMeasureScope $this$maxIntrinsicHeight, IntrinsicMeasurable measurable, int width) {
        Intrinsics.checkNotNullParameter($this$maxIntrinsicHeight, "<this>");
        Intrinsics.checkNotNullParameter(measurable, "measurable");
        return getLayoutCache($this$maxIntrinsicHeight).intrinsicHeight(width, $this$maxIntrinsicHeight.getLayoutDirection());
    }

    public final void drawNonExtension(ContentDrawScope contentDrawScope) {
        Intrinsics.checkNotNullParameter(contentDrawScope, "contentDrawScope");
        draw(contentDrawScope);
    }

    /* JADX WARN: Removed duplicated region for block: B:55:0x015a  */
    @Override // androidx.compose.ui.node.DrawModifierNode
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void draw(androidx.compose.ui.graphics.drawscope.ContentDrawScope r30) {
        /*
            Method dump skipped, instructions count: 350
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.modifiers.TextAnnotatedStringNode.draw(androidx.compose.ui.graphics.drawscope.ContentDrawScope):void");
    }
}
