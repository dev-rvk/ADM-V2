package androidx.compose.ui.text;

import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverKt;
import androidx.compose.runtime.saveable.SaverScope;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.intl.Locale;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextDirection;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.text.style.TextIndent;
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnitKt;
import androidx.compose.ui.unit.TextUnitType;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ULong;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Savers.kt */
@Metadata(d1 = {"\u0000Ú\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aL\u0010J\u001a\u0004\u0018\u0001HK\"\u0014\b\u0000\u0010L*\u000e\u0012\u0004\u0012\u0002HM\u0012\u0004\u0012\u0002HN0\u0001\"\u0004\b\u0001\u0010M\"\u0004\b\u0002\u0010N\"\u0006\b\u0003\u0010K\u0018\u00012\b\u0010O\u001a\u0004\u0018\u0001HN2\u0006\u0010P\u001a\u0002HLH\u0080\b¢\u0006\u0002\u0010Q\u001a\"\u0010J\u001a\u0004\u0018\u0001HK\"\u0006\b\u0000\u0010K\u0018\u00012\b\u0010O\u001a\u0004\u0018\u00010\u0003H\u0080\b¢\u0006\u0002\u0010R\u001aI\u0010S\u001a\u00020\u0003\"\u0014\b\u0000\u0010L*\u000e\u0012\u0004\u0012\u0002HM\u0012\u0004\u0012\u0002HN0\u0001\"\u0004\b\u0001\u0010M\"\u0004\b\u0002\u0010N2\b\u0010O\u001a\u0004\u0018\u0001HM2\u0006\u0010P\u001a\u0002HL2\u0006\u0010T\u001a\u00020UH\u0000¢\u0006\u0002\u0010V\u001a\u001f\u0010S\u001a\u0004\u0018\u0001HL\"\u0004\b\u0000\u0010L2\b\u0010O\u001a\u0004\u0018\u0001HLH\u0000¢\u0006\u0002\u0010R\" \u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005\"(\u0010\u0006\u001a\u001c\u0012\u0012\u0012\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00030\b0\u0007\u0012\u0004\u0012\u00020\u00030\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"(\u0010\t\u001a\u0016\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00030\b\u0012\u0004\u0012\u00020\u00030\u0001X\u0082\u0004¢\u0006\b\n\u0000\u0012\u0004\b\n\u0010\u000b\"\u001d\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00030\u0001X\u0082\u0004ø\u0001\u0000¢\u0006\u0002\n\u0000\"\u001d\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00030\u0001X\u0082\u0004ø\u0001\u0000¢\u0006\u0002\n\u0000\"\u001a\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00030\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u001a\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00030\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u001a\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00030\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u001d\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00030\u0001X\u0082\u0004ø\u0001\u0000¢\u0006\u0002\n\u0000\" \u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00030\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0005\"\u001a\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u00030\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\" \u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u00030\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0005\"\u001a\u0010 \u001a\u000e\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\u00030\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u001a\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020\u00030\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u001a\u0010$\u001a\u000e\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020\u00030\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u001d\u0010&\u001a\u000e\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020\u00030\u0001X\u0082\u0004ø\u0001\u0000¢\u0006\u0002\n\u0000\"#\u0010(\u001a\u000e\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020\u00030\u0001X\u0082\u0004ø\u0001\u0000¢\u0006\b\n\u0000\u0012\u0004\b*\u0010\u000b\" \u0010+\u001a\u000e\u0012\u0004\u0012\u00020,\u0012\u0004\u0012\u00020\u00030\u0001X\u0082\u0004¢\u0006\b\n\u0000\u0012\u0004\b-\u0010\u000b\"\u001a\u0010.\u001a\u000e\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u00020\u00030\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"'\u00100\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00030\u0001*\u0002018@X\u0080\u0004ø\u0001\u0000¢\u0006\u0006\u001a\u0004\b2\u00103\"'\u00100\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00030\u0001*\u0002048@X\u0080\u0004ø\u0001\u0000¢\u0006\u0006\u001a\u0004\b2\u00105\"$\u00100\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u00030\u0001*\u0002068@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b2\u00107\"'\u00100\u001a\u000e\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020\u00030\u0001*\u0002088@X\u0080\u0004ø\u0001\u0000¢\u0006\u0006\u001a\u0004\b2\u00109\"$\u00100\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00030\u0001*\u00020:8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b2\u0010;\"$\u00100\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00030\u0001*\u00020<8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b2\u0010=\"$\u00100\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00030\u0001*\u00020>8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b2\u0010?\"'\u00100\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00030\u0001*\u00020@8@X\u0080\u0004ø\u0001\u0000¢\u0006\u0006\u001a\u0004\b2\u0010A\"$\u00100\u001a\u000e\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\u00030\u0001*\u00020B8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b2\u0010C\"$\u00100\u001a\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020\u00030\u0001*\u00020D8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b2\u0010E\"$\u00100\u001a\u000e\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020\u00030\u0001*\u00020F8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b2\u0010G\"'\u00100\u001a\u000e\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020\u00030\u0001*\u00020H8@X\u0080\u0004ø\u0001\u0000¢\u0006\u0006\u001a\u0004\b2\u0010I\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006W"}, d2 = {"AnnotatedStringSaver", "Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/ui/text/AnnotatedString;", "", "getAnnotatedStringSaver", "()Landroidx/compose/runtime/saveable/Saver;", "AnnotationRangeListSaver", "", "Landroidx/compose/ui/text/AnnotatedString$Range;", "AnnotationRangeSaver", "getAnnotationRangeSaver$annotations", "()V", "BaselineShiftSaver", "Landroidx/compose/ui/text/style/BaselineShift;", "ColorSaver", "Landroidx/compose/ui/graphics/Color;", "FontWeightSaver", "Landroidx/compose/ui/text/font/FontWeight;", "LocaleListSaver", "Landroidx/compose/ui/text/intl/LocaleList;", "LocaleSaver", "Landroidx/compose/ui/text/intl/Locale;", "OffsetSaver", "Landroidx/compose/ui/geometry/Offset;", "ParagraphStyleSaver", "Landroidx/compose/ui/text/ParagraphStyle;", "getParagraphStyleSaver", "ShadowSaver", "Landroidx/compose/ui/graphics/Shadow;", "SpanStyleSaver", "Landroidx/compose/ui/text/SpanStyle;", "getSpanStyleSaver", "TextDecorationSaver", "Landroidx/compose/ui/text/style/TextDecoration;", "TextGeometricTransformSaver", "Landroidx/compose/ui/text/style/TextGeometricTransform;", "TextIndentSaver", "Landroidx/compose/ui/text/style/TextIndent;", "TextRangeSaver", "Landroidx/compose/ui/text/TextRange;", "TextUnitSaver", "Landroidx/compose/ui/unit/TextUnit;", "getTextUnitSaver$annotations", "UrlAnnotationSaver", "Landroidx/compose/ui/text/UrlAnnotation;", "getUrlAnnotationSaver$annotations", "VerbatimTtsAnnotationSaver", "Landroidx/compose/ui/text/VerbatimTtsAnnotation;", "Saver", "Landroidx/compose/ui/geometry/Offset$Companion;", "getSaver", "(Landroidx/compose/ui/geometry/Offset$Companion;)Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/ui/graphics/Color$Companion;", "(Landroidx/compose/ui/graphics/Color$Companion;)Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/ui/graphics/Shadow$Companion;", "(Landroidx/compose/ui/graphics/Shadow$Companion;)Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/ui/text/TextRange$Companion;", "(Landroidx/compose/ui/text/TextRange$Companion;)Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/ui/text/font/FontWeight$Companion;", "(Landroidx/compose/ui/text/font/FontWeight$Companion;)Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/ui/text/intl/Locale$Companion;", "(Landroidx/compose/ui/text/intl/Locale$Companion;)Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/ui/text/intl/LocaleList$Companion;", "(Landroidx/compose/ui/text/intl/LocaleList$Companion;)Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/ui/text/style/BaselineShift$Companion;", "(Landroidx/compose/ui/text/style/BaselineShift$Companion;)Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/ui/text/style/TextDecoration$Companion;", "(Landroidx/compose/ui/text/style/TextDecoration$Companion;)Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/ui/text/style/TextGeometricTransform$Companion;", "(Landroidx/compose/ui/text/style/TextGeometricTransform$Companion;)Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/ui/text/style/TextIndent$Companion;", "(Landroidx/compose/ui/text/style/TextIndent$Companion;)Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/ui/unit/TextUnit$Companion;", "(Landroidx/compose/ui/unit/TextUnit$Companion;)Landroidx/compose/runtime/saveable/Saver;", "restore", "Result", "T", "Original", "Saveable", "value", "saver", "(Ljava/lang/Object;Landroidx/compose/runtime/saveable/Saver;)Ljava/lang/Object;", "(Ljava/lang/Object;)Ljava/lang/Object;", "save", "scope", "Landroidx/compose/runtime/saveable/SaverScope;", "(Ljava/lang/Object;Landroidx/compose/runtime/saveable/Saver;Landroidx/compose/runtime/saveable/SaverScope;)Ljava/lang/Object;", "ui-text_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class SaversKt {
    private static final Saver<AnnotatedString, Object> AnnotatedStringSaver = SaverKt.Saver(new Function2<SaverScope, AnnotatedString, Object>() { // from class: androidx.compose.ui.text.SaversKt$AnnotatedStringSaver$1
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(SaverScope Saver, AnnotatedString it) {
            Saver saver;
            Saver saver2;
            Saver saver3;
            Intrinsics.checkNotNullParameter(Saver, "$this$Saver");
            Intrinsics.checkNotNullParameter(it, "it");
            Object save = SaversKt.save(it.getText());
            List<AnnotatedString.Range<SpanStyle>> spanStyles = it.getSpanStyles();
            saver = SaversKt.AnnotationRangeListSaver;
            Object save2 = SaversKt.save(spanStyles, saver, Saver);
            List<AnnotatedString.Range<ParagraphStyle>> paragraphStyles = it.getParagraphStyles();
            saver2 = SaversKt.AnnotationRangeListSaver;
            Object save3 = SaversKt.save(paragraphStyles, saver2, Saver);
            List<AnnotatedString.Range<? extends Object>> annotations$ui_text_release = it.getAnnotations$ui_text_release();
            saver3 = SaversKt.AnnotationRangeListSaver;
            return CollectionsKt.arrayListOf(save, save2, save3, SaversKt.save(annotations$ui_text_release, saver3, Saver));
        }
    }, new Function1<Object, AnnotatedString>() { // from class: androidx.compose.ui.text.SaversKt$AnnotatedStringSaver$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function1
        public final AnnotatedString invoke(Object it) {
            Saver saver$iv;
            List list;
            Saver saver$iv2;
            List list2;
            List list3;
            List list4;
            Saver saver$iv3;
            Intrinsics.checkNotNullParameter(it, "it");
            List list5 = (List) it;
            Object value$iv = list5.get(1);
            saver$iv = SaversKt.AnnotationRangeListSaver;
            List list6 = null;
            if (Intrinsics.areEqual(value$iv, (Object) false)) {
                list = null;
            } else {
                list = value$iv != null ? (List) saver$iv.restore(value$iv) : null;
            }
            List spanStylesOrNull = list;
            Object value$iv2 = list5.get(2);
            saver$iv2 = SaversKt.AnnotationRangeListSaver;
            if (Intrinsics.areEqual(value$iv2, (Object) false)) {
                list2 = null;
            } else {
                list2 = value$iv2 != null ? (List) saver$iv2.restore(value$iv2) : null;
            }
            List paragraphStylesOrNull = list2;
            Object value$iv3 = list5.get(0);
            String str = value$iv3 != null ? (String) value$iv3 : null;
            Intrinsics.checkNotNull(str);
            if (spanStylesOrNull != null) {
                List list7 = spanStylesOrNull;
                if (list7.isEmpty()) {
                    list7 = null;
                }
                list3 = list7;
            } else {
                list3 = null;
            }
            if (paragraphStylesOrNull != null) {
                List list8 = paragraphStylesOrNull;
                if (list8.isEmpty()) {
                    list8 = null;
                }
                list4 = list8;
            } else {
                list4 = null;
            }
            Object value$iv4 = list5.get(3);
            saver$iv3 = SaversKt.AnnotationRangeListSaver;
            if (!Intrinsics.areEqual(value$iv4, (Object) false) && value$iv4 != null) {
                list6 = (List) saver$iv3.restore(value$iv4);
            }
            return new AnnotatedString(str, list3, list4, list6);
        }
    });
    private static final Saver<List<AnnotatedString.Range<? extends Object>>, Object> AnnotationRangeListSaver = SaverKt.Saver(new Function2<SaverScope, List<? extends AnnotatedString.Range<? extends Object>>, Object>() { // from class: androidx.compose.ui.text.SaversKt$AnnotationRangeListSaver$1
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(SaverScope Saver, List<? extends AnnotatedString.Range<? extends Object>> it) {
            Saver saver;
            Intrinsics.checkNotNullParameter(Saver, "$this$Saver");
            Intrinsics.checkNotNullParameter(it, "it");
            List target$iv = new ArrayList(it.size());
            int size = it.size();
            for (int index$iv$iv = 0; index$iv$iv < size; index$iv$iv++) {
                AnnotatedString.Range item$iv$iv = it.get(index$iv$iv);
                AnnotatedString.Range range = item$iv$iv;
                saver = SaversKt.AnnotationRangeSaver;
                target$iv.add(SaversKt.save(range, saver, Saver));
            }
            List $this$fastMap$iv = target$iv;
            return $this$fastMap$iv;
        }
    }, new Function1<Object, List<? extends AnnotatedString.Range<? extends Object>>>() { // from class: androidx.compose.ui.text.SaversKt$AnnotationRangeListSaver$2
        @Override // kotlin.jvm.functions.Function1
        public final List<? extends AnnotatedString.Range<? extends Object>> invoke(Object it) {
            Saver saver$iv;
            Intrinsics.checkNotNullParameter(it, "it");
            List list = (List) it;
            ArrayList target$iv = new ArrayList(list.size());
            int size = list.size();
            for (int index$iv$iv = 0; index$iv$iv < size; index$iv$iv++) {
                Object item$iv$iv = list.get(index$iv$iv);
                ArrayList arrayList = target$iv;
                saver$iv = SaversKt.AnnotationRangeSaver;
                AnnotatedString.Range range = null;
                if (!Intrinsics.areEqual(item$iv$iv, (Object) false) && item$iv$iv != null) {
                    Object it$iv = saver$iv.restore(item$iv$iv);
                    range = (AnnotatedString.Range) it$iv;
                }
                Intrinsics.checkNotNull(range);
                AnnotatedString.Range range2 = range;
                arrayList.add(range2);
            }
            return target$iv;
        }
    });
    private static final Saver<AnnotatedString.Range<? extends Object>, Object> AnnotationRangeSaver = SaverKt.Saver(new Function2<SaverScope, AnnotatedString.Range<? extends Object>, Object>() { // from class: androidx.compose.ui.text.SaversKt$AnnotationRangeSaver$1

        /* compiled from: Savers.kt */
        @Metadata(k = 3, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
        /* loaded from: classes.dex */
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[AnnotationType.values().length];
                try {
                    iArr[AnnotationType.Paragraph.ordinal()] = 1;
                } catch (NoSuchFieldError e) {
                }
                try {
                    iArr[AnnotationType.Span.ordinal()] = 2;
                } catch (NoSuchFieldError e2) {
                }
                try {
                    iArr[AnnotationType.VerbatimTts.ordinal()] = 3;
                } catch (NoSuchFieldError e3) {
                }
                try {
                    iArr[AnnotationType.Url.ordinal()] = 4;
                } catch (NoSuchFieldError e4) {
                }
                try {
                    iArr[AnnotationType.String.ordinal()] = 5;
                } catch (NoSuchFieldError e5) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(SaverScope Saver, AnnotatedString.Range<? extends Object> it) {
            AnnotationType marker;
            Object item;
            Saver saver;
            Saver saver2;
            Intrinsics.checkNotNullParameter(Saver, "$this$Saver");
            Intrinsics.checkNotNullParameter(it, "it");
            Object item2 = it.getItem();
            if (item2 instanceof ParagraphStyle) {
                marker = AnnotationType.Paragraph;
            } else if (item2 instanceof SpanStyle) {
                marker = AnnotationType.Span;
            } else if (item2 instanceof VerbatimTtsAnnotation) {
                marker = AnnotationType.VerbatimTts;
            } else {
                marker = item2 instanceof UrlAnnotation ? AnnotationType.Url : AnnotationType.String;
            }
            switch (WhenMappings.$EnumSwitchMapping$0[marker.ordinal()]) {
                case 1:
                    Object item3 = it.getItem();
                    Intrinsics.checkNotNull(item3, "null cannot be cast to non-null type androidx.compose.ui.text.ParagraphStyle");
                    item = SaversKt.save((ParagraphStyle) item3, SaversKt.getParagraphStyleSaver(), Saver);
                    break;
                case 2:
                    Object item4 = it.getItem();
                    Intrinsics.checkNotNull(item4, "null cannot be cast to non-null type androidx.compose.ui.text.SpanStyle");
                    item = SaversKt.save((SpanStyle) item4, SaversKt.getSpanStyleSaver(), Saver);
                    break;
                case 3:
                    Object item5 = it.getItem();
                    Intrinsics.checkNotNull(item5, "null cannot be cast to non-null type androidx.compose.ui.text.VerbatimTtsAnnotation");
                    saver = SaversKt.VerbatimTtsAnnotationSaver;
                    item = SaversKt.save((VerbatimTtsAnnotation) item5, saver, Saver);
                    break;
                case 4:
                    Object item6 = it.getItem();
                    Intrinsics.checkNotNull(item6, "null cannot be cast to non-null type androidx.compose.ui.text.UrlAnnotation");
                    saver2 = SaversKt.UrlAnnotationSaver;
                    item = SaversKt.save((UrlAnnotation) item6, saver2, Saver);
                    break;
                case 5:
                    item = SaversKt.save(it.getItem());
                    break;
                default:
                    throw new NoWhenBranchMatchedException();
            }
            return CollectionsKt.arrayListOf(SaversKt.save(marker), item, SaversKt.save(Integer.valueOf(it.getStart())), SaversKt.save(Integer.valueOf(it.getEnd())), SaversKt.save(it.getTag()));
        }
    }, new Function1<Object, AnnotatedString.Range<? extends Object>>() { // from class: androidx.compose.ui.text.SaversKt$AnnotationRangeSaver$2

        /* compiled from: Savers.kt */
        @Metadata(k = 3, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
        /* loaded from: classes.dex */
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[AnnotationType.values().length];
                try {
                    iArr[AnnotationType.Paragraph.ordinal()] = 1;
                } catch (NoSuchFieldError e) {
                }
                try {
                    iArr[AnnotationType.Span.ordinal()] = 2;
                } catch (NoSuchFieldError e2) {
                }
                try {
                    iArr[AnnotationType.VerbatimTts.ordinal()] = 3;
                } catch (NoSuchFieldError e3) {
                }
                try {
                    iArr[AnnotationType.Url.ordinal()] = 4;
                } catch (NoSuchFieldError e4) {
                }
                try {
                    iArr[AnnotationType.String.ordinal()] = 5;
                } catch (NoSuchFieldError e5) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function1
        public final AnnotatedString.Range<? extends Object> invoke(Object it) {
            Object it$iv;
            Object it$iv2;
            String str;
            Saver saver$iv;
            Saver saver$iv2;
            Intrinsics.checkNotNullParameter(it, "it");
            List list = (List) it;
            Object value$iv = list.get(0);
            Object it$iv3 = null;
            AnnotationType annotationType = value$iv != null ? (AnnotationType) value$iv : null;
            Intrinsics.checkNotNull(annotationType);
            AnnotationType marker = annotationType;
            Object value$iv2 = list.get(2);
            if (value$iv2 == null) {
                it$iv = null;
            } else {
                it$iv = (Integer) value$iv2;
            }
            Intrinsics.checkNotNull(it$iv);
            int start = ((Number) it$iv).intValue();
            Object value$iv3 = list.get(3);
            if (value$iv3 == null) {
                it$iv2 = null;
            } else {
                it$iv2 = (Integer) value$iv3;
            }
            Intrinsics.checkNotNull(it$iv2);
            int end = ((Number) it$iv2).intValue();
            Object value$iv4 = list.get(4);
            if (value$iv4 == null) {
                str = null;
            } else {
                str = (String) value$iv4;
            }
            Intrinsics.checkNotNull(str);
            String tag = str;
            switch (WhenMappings.$EnumSwitchMapping$0[marker.ordinal()]) {
                case 1:
                    Object value$iv5 = list.get(1);
                    Saver saver$iv3 = SaversKt.getParagraphStyleSaver();
                    if (!Intrinsics.areEqual(value$iv5, (Object) false) && value$iv5 != null) {
                        it$iv3 = (ParagraphStyle) saver$iv3.restore(value$iv5);
                    }
                    Intrinsics.checkNotNull(it$iv3);
                    return new AnnotatedString.Range<>(it$iv3, start, end, tag);
                case 2:
                    Object value$iv6 = list.get(1);
                    Saver saver$iv4 = SaversKt.getSpanStyleSaver();
                    if (!Intrinsics.areEqual(value$iv6, (Object) false) && value$iv6 != null) {
                        it$iv3 = (SpanStyle) saver$iv4.restore(value$iv6);
                    }
                    Intrinsics.checkNotNull(it$iv3);
                    return new AnnotatedString.Range<>(it$iv3, start, end, tag);
                case 3:
                    Object value$iv7 = list.get(1);
                    saver$iv = SaversKt.VerbatimTtsAnnotationSaver;
                    if (!Intrinsics.areEqual(value$iv7, (Object) false) && value$iv7 != null) {
                        it$iv3 = (VerbatimTtsAnnotation) saver$iv.restore(value$iv7);
                    }
                    Intrinsics.checkNotNull(it$iv3);
                    return new AnnotatedString.Range<>(it$iv3, start, end, tag);
                case 4:
                    Object value$iv8 = list.get(1);
                    saver$iv2 = SaversKt.UrlAnnotationSaver;
                    if (!Intrinsics.areEqual(value$iv8, (Object) false) && value$iv8 != null) {
                        it$iv3 = (UrlAnnotation) saver$iv2.restore(value$iv8);
                    }
                    Intrinsics.checkNotNull(it$iv3);
                    return new AnnotatedString.Range<>(it$iv3, start, end, tag);
                case 5:
                    Object value$iv9 = list.get(1);
                    if (value$iv9 != null) {
                        it$iv3 = (String) value$iv9;
                    }
                    Intrinsics.checkNotNull(it$iv3);
                    return new AnnotatedString.Range<>(it$iv3, start, end, tag);
                default:
                    throw new NoWhenBranchMatchedException();
            }
        }
    });
    private static final Saver<VerbatimTtsAnnotation, Object> VerbatimTtsAnnotationSaver = SaverKt.Saver(new Function2<SaverScope, VerbatimTtsAnnotation, Object>() { // from class: androidx.compose.ui.text.SaversKt$VerbatimTtsAnnotationSaver$1
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(SaverScope Saver, VerbatimTtsAnnotation it) {
            Intrinsics.checkNotNullParameter(Saver, "$this$Saver");
            Intrinsics.checkNotNullParameter(it, "it");
            return SaversKt.save(it.getVerbatim());
        }
    }, new Function1<Object, VerbatimTtsAnnotation>() { // from class: androidx.compose.ui.text.SaversKt$VerbatimTtsAnnotationSaver$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function1
        public final VerbatimTtsAnnotation invoke(Object it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return new VerbatimTtsAnnotation((String) it);
        }
    });
    private static final Saver<UrlAnnotation, Object> UrlAnnotationSaver = SaverKt.Saver(new Function2<SaverScope, UrlAnnotation, Object>() { // from class: androidx.compose.ui.text.SaversKt$UrlAnnotationSaver$1
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(SaverScope Saver, UrlAnnotation it) {
            Intrinsics.checkNotNullParameter(Saver, "$this$Saver");
            Intrinsics.checkNotNullParameter(it, "it");
            return SaversKt.save(it.getUrl());
        }
    }, new Function1<Object, UrlAnnotation>() { // from class: androidx.compose.ui.text.SaversKt$UrlAnnotationSaver$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function1
        public final UrlAnnotation invoke(Object it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return new UrlAnnotation((String) it);
        }
    });
    private static final Saver<ParagraphStyle, Object> ParagraphStyleSaver = SaverKt.Saver(new Function2<SaverScope, ParagraphStyle, Object>() { // from class: androidx.compose.ui.text.SaversKt$ParagraphStyleSaver$1
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(SaverScope Saver, ParagraphStyle it) {
            Intrinsics.checkNotNullParameter(Saver, "$this$Saver");
            Intrinsics.checkNotNullParameter(it, "it");
            return CollectionsKt.arrayListOf(SaversKt.save(it.getTextAlign()), SaversKt.save(it.getTextDirection()), SaversKt.save(TextUnit.m5389boximpl(it.getLineHeight()), SaversKt.getSaver(TextUnit.INSTANCE), Saver), SaversKt.save(it.getTextIndent(), SaversKt.getSaver(TextIndent.INSTANCE), Saver));
        }
    }, new Function1<Object, ParagraphStyle>() { // from class: androidx.compose.ui.text.SaversKt$ParagraphStyleSaver$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function1
        public final ParagraphStyle invoke(Object it) {
            TextDirection textDirection;
            TextUnit restore;
            TextIndent restore2;
            Intrinsics.checkNotNullParameter(it, "it");
            List list = (List) it;
            Object value$iv = list.get(0);
            TextAlign textAlign = value$iv != null ? (TextAlign) value$iv : null;
            Object value$iv2 = list.get(1);
            if (value$iv2 == null) {
                textDirection = null;
            } else {
                textDirection = (TextDirection) value$iv2;
            }
            Object value$iv3 = list.get(2);
            Saver saver$iv = SaversKt.getSaver(TextUnit.INSTANCE);
            if (Intrinsics.areEqual(value$iv3, (Object) false)) {
                restore = null;
            } else {
                restore = value$iv3 != null ? saver$iv.restore(value$iv3) : null;
            }
            Intrinsics.checkNotNull(restore);
            long packedValue = restore.getPackedValue();
            Object value$iv4 = list.get(3);
            Saver saver$iv2 = SaversKt.getSaver(TextIndent.INSTANCE);
            if (Intrinsics.areEqual(value$iv4, (Object) false)) {
                restore2 = null;
            } else {
                restore2 = value$iv4 != null ? saver$iv2.restore(value$iv4) : null;
            }
            return new ParagraphStyle(textAlign, textDirection, packedValue, restore2, null, null, null, null, null, 496, null);
        }
    });
    private static final Saver<SpanStyle, Object> SpanStyleSaver = SaverKt.Saver(new Function2<SaverScope, SpanStyle, Object>() { // from class: androidx.compose.ui.text.SaversKt$SpanStyleSaver$1
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(SaverScope Saver, SpanStyle it) {
            Intrinsics.checkNotNullParameter(Saver, "$this$Saver");
            Intrinsics.checkNotNullParameter(it, "it");
            return CollectionsKt.arrayListOf(SaversKt.save(Color.m2939boximpl(it.m4685getColor0d7_KjU()), SaversKt.getSaver(Color.INSTANCE), Saver), SaversKt.save(TextUnit.m5389boximpl(it.getFontSize()), SaversKt.getSaver(TextUnit.INSTANCE), Saver), SaversKt.save(it.getFontWeight(), SaversKt.getSaver(FontWeight.INSTANCE), Saver), SaversKt.save(it.getFontStyle()), SaversKt.save(it.getFontSynthesis()), SaversKt.save(-1), SaversKt.save(it.getFontFeatureSettings()), SaversKt.save(TextUnit.m5389boximpl(it.getLetterSpacing()), SaversKt.getSaver(TextUnit.INSTANCE), Saver), SaversKt.save(it.getBaselineShift(), SaversKt.getSaver(BaselineShift.INSTANCE), Saver), SaversKt.save(it.getTextGeometricTransform(), SaversKt.getSaver(TextGeometricTransform.INSTANCE), Saver), SaversKt.save(it.getLocaleList(), SaversKt.getSaver(LocaleList.INSTANCE), Saver), SaversKt.save(Color.m2939boximpl(it.getBackground()), SaversKt.getSaver(Color.INSTANCE), Saver), SaversKt.save(it.getTextDecoration(), SaversKt.getSaver(TextDecoration.INSTANCE), Saver), SaversKt.save(it.getShadow(), SaversKt.getSaver(Shadow.INSTANCE), Saver));
        }
    }, new Function1<Object, SpanStyle>() { // from class: androidx.compose.ui.text.SaversKt$SpanStyleSaver$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function1
        public final SpanStyle invoke(Object it) {
            Color restore;
            TextUnit restore2;
            FontWeight restore3;
            TextUnit restore4;
            BaselineShift restore5;
            TextGeometricTransform restore6;
            LocaleList restore7;
            Color restore8;
            TextDecoration restore9;
            Shadow restore10;
            Intrinsics.checkNotNullParameter(it, "it");
            List list = (List) it;
            Object value$iv = list.get(0);
            Saver saver$iv = SaversKt.getSaver(Color.INSTANCE);
            if (Intrinsics.areEqual(value$iv, (Object) false)) {
                restore = null;
            } else {
                restore = value$iv != null ? saver$iv.restore(value$iv) : null;
            }
            Intrinsics.checkNotNull(restore);
            long m2959unboximpl = restore.m2959unboximpl();
            Object value$iv2 = list.get(1);
            Saver saver$iv2 = SaversKt.getSaver(TextUnit.INSTANCE);
            if (Intrinsics.areEqual(value$iv2, (Object) false)) {
                restore2 = null;
            } else {
                restore2 = value$iv2 != null ? saver$iv2.restore(value$iv2) : null;
            }
            Intrinsics.checkNotNull(restore2);
            long packedValue = restore2.getPackedValue();
            Object value$iv3 = list.get(2);
            Saver saver$iv3 = SaversKt.getSaver(FontWeight.INSTANCE);
            if (Intrinsics.areEqual(value$iv3, (Object) false)) {
                restore3 = null;
            } else {
                restore3 = value$iv3 != null ? saver$iv3.restore(value$iv3) : null;
            }
            Object value$iv4 = list.get(3);
            FontStyle fontStyle = value$iv4 != null ? (FontStyle) value$iv4 : null;
            Object value$iv5 = list.get(4);
            FontSynthesis fontSynthesis = value$iv5 != null ? (FontSynthesis) value$iv5 : null;
            Object value$iv6 = list.get(6);
            String str = value$iv6 != null ? (String) value$iv6 : null;
            Object value$iv7 = list.get(7);
            Saver saver$iv4 = SaversKt.getSaver(TextUnit.INSTANCE);
            if (Intrinsics.areEqual(value$iv7, (Object) false)) {
                restore4 = null;
            } else {
                restore4 = value$iv7 != null ? saver$iv4.restore(value$iv7) : null;
            }
            Intrinsics.checkNotNull(restore4);
            long packedValue2 = restore4.getPackedValue();
            Object value$iv8 = list.get(8);
            Saver saver$iv5 = SaversKt.getSaver(BaselineShift.INSTANCE);
            if (Intrinsics.areEqual(value$iv8, (Object) false)) {
                restore5 = null;
            } else {
                restore5 = value$iv8 != null ? saver$iv5.restore(value$iv8) : null;
            }
            Object value$iv9 = list.get(9);
            Saver $this$restore_u24lambda_u243_u24lambda_u242$iv = SaversKt.getSaver(TextGeometricTransform.INSTANCE);
            if (Intrinsics.areEqual(value$iv9, (Object) false)) {
                restore6 = null;
            } else {
                restore6 = value$iv9 != null ? $this$restore_u24lambda_u243_u24lambda_u242$iv.restore(value$iv9) : null;
            }
            Object value$iv10 = list.get(10);
            Saver $this$restore_u24lambda_u243_u24lambda_u242$iv2 = SaversKt.getSaver(LocaleList.INSTANCE);
            if (Intrinsics.areEqual(value$iv10, (Object) false)) {
                restore7 = null;
            } else {
                restore7 = value$iv10 != null ? $this$restore_u24lambda_u243_u24lambda_u242$iv2.restore(value$iv10) : null;
            }
            Object value$iv11 = list.get(11);
            Saver $this$restore_u24lambda_u243_u24lambda_u242$iv3 = SaversKt.getSaver(Color.INSTANCE);
            if (Intrinsics.areEqual(value$iv11, (Object) false)) {
                restore8 = null;
            } else {
                restore8 = value$iv11 != null ? $this$restore_u24lambda_u243_u24lambda_u242$iv3.restore(value$iv11) : null;
            }
            Intrinsics.checkNotNull(restore8);
            long m2959unboximpl2 = restore8.m2959unboximpl();
            Object value$iv12 = list.get(12);
            Saver $this$restore_u24lambda_u243_u24lambda_u242$iv4 = SaversKt.getSaver(TextDecoration.INSTANCE);
            if (Intrinsics.areEqual(value$iv12, (Object) false)) {
                restore9 = null;
            } else {
                restore9 = value$iv12 != null ? $this$restore_u24lambda_u243_u24lambda_u242$iv4.restore(value$iv12) : null;
            }
            Object value$iv13 = list.get(13);
            Saver saver$iv6 = SaversKt.getSaver(Shadow.INSTANCE);
            if (Intrinsics.areEqual(value$iv13, (Object) false)) {
                restore10 = null;
            } else {
                restore10 = value$iv13 != null ? saver$iv6.restore(value$iv13) : null;
            }
            return new SpanStyle(m2959unboximpl, packedValue, restore3, fontStyle, fontSynthesis, (FontFamily) null, str, packedValue2, restore5, restore6, restore7, m2959unboximpl2, restore9, restore10, (PlatformSpanStyle) null, (DrawStyle) null, 49184, (DefaultConstructorMarker) null);
        }
    });
    private static final Saver<TextDecoration, Object> TextDecorationSaver = SaverKt.Saver(new Function2<SaverScope, TextDecoration, Object>() { // from class: androidx.compose.ui.text.SaversKt$TextDecorationSaver$1
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(SaverScope Saver, TextDecoration it) {
            Intrinsics.checkNotNullParameter(Saver, "$this$Saver");
            Intrinsics.checkNotNullParameter(it, "it");
            return Integer.valueOf(it.getMask());
        }
    }, new Function1<Object, TextDecoration>() { // from class: androidx.compose.ui.text.SaversKt$TextDecorationSaver$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function1
        public final TextDecoration invoke(Object it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return new TextDecoration(((Integer) it).intValue());
        }
    });
    private static final Saver<TextGeometricTransform, Object> TextGeometricTransformSaver = SaverKt.Saver(new Function2<SaverScope, TextGeometricTransform, Object>() { // from class: androidx.compose.ui.text.SaversKt$TextGeometricTransformSaver$1
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(SaverScope Saver, TextGeometricTransform it) {
            Intrinsics.checkNotNullParameter(Saver, "$this$Saver");
            Intrinsics.checkNotNullParameter(it, "it");
            return CollectionsKt.arrayListOf(Float.valueOf(it.getScaleX()), Float.valueOf(it.getSkewX()));
        }
    }, new Function1<Object, TextGeometricTransform>() { // from class: androidx.compose.ui.text.SaversKt$TextGeometricTransformSaver$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function1
        public final TextGeometricTransform invoke(Object it) {
            Intrinsics.checkNotNullParameter(it, "it");
            List list = (List) it;
            return new TextGeometricTransform(((Number) list.get(0)).floatValue(), ((Number) list.get(1)).floatValue());
        }
    });
    private static final Saver<TextIndent, Object> TextIndentSaver = SaverKt.Saver(new Function2<SaverScope, TextIndent, Object>() { // from class: androidx.compose.ui.text.SaversKt$TextIndentSaver$1
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(SaverScope Saver, TextIndent it) {
            Intrinsics.checkNotNullParameter(Saver, "$this$Saver");
            Intrinsics.checkNotNullParameter(it, "it");
            return CollectionsKt.arrayListOf(SaversKt.save(TextUnit.m5389boximpl(it.getFirstLine()), SaversKt.getSaver(TextUnit.INSTANCE), Saver), SaversKt.save(TextUnit.m5389boximpl(it.getRestLine()), SaversKt.getSaver(TextUnit.INSTANCE), Saver));
        }
    }, new Function1<Object, TextIndent>() { // from class: androidx.compose.ui.text.SaversKt$TextIndentSaver$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function1
        public final TextIndent invoke(Object it) {
            TextUnit restore;
            Intrinsics.checkNotNullParameter(it, "it");
            List list = (List) it;
            Object value$iv = list.get(0);
            Saver saver$iv = SaversKt.getSaver(TextUnit.INSTANCE);
            TextUnit textUnit = null;
            if (Intrinsics.areEqual(value$iv, (Object) false)) {
                restore = null;
            } else {
                restore = value$iv != null ? saver$iv.restore(value$iv) : null;
            }
            Intrinsics.checkNotNull(restore);
            long packedValue = restore.getPackedValue();
            Object value$iv2 = list.get(1);
            Saver saver$iv2 = SaversKt.getSaver(TextUnit.INSTANCE);
            if (!Intrinsics.areEqual(value$iv2, (Object) false) && value$iv2 != null) {
                textUnit = saver$iv2.restore(value$iv2);
            }
            Intrinsics.checkNotNull(textUnit);
            return new TextIndent(packedValue, textUnit.getPackedValue(), null);
        }
    });
    private static final Saver<FontWeight, Object> FontWeightSaver = SaverKt.Saver(new Function2<SaverScope, FontWeight, Object>() { // from class: androidx.compose.ui.text.SaversKt$FontWeightSaver$1
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(SaverScope Saver, FontWeight it) {
            Intrinsics.checkNotNullParameter(Saver, "$this$Saver");
            Intrinsics.checkNotNullParameter(it, "it");
            return Integer.valueOf(it.getWeight());
        }
    }, new Function1<Object, FontWeight>() { // from class: androidx.compose.ui.text.SaversKt$FontWeightSaver$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function1
        public final FontWeight invoke(Object it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return new FontWeight(((Integer) it).intValue());
        }
    });
    private static final Saver<BaselineShift, Object> BaselineShiftSaver = SaverKt.Saver(new Function2<SaverScope, BaselineShift, Object>() { // from class: androidx.compose.ui.text.SaversKt$BaselineShiftSaver$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(SaverScope saverScope, BaselineShift baselineShift) {
            return m4665invoke8a2Sb4w(saverScope, baselineShift.m4989unboximpl());
        }

        /* renamed from: invoke-8a2Sb4w, reason: not valid java name */
        public final Object m4665invoke8a2Sb4w(SaverScope Saver, float it) {
            Intrinsics.checkNotNullParameter(Saver, "$this$Saver");
            return Float.valueOf(it);
        }
    }, new Function1<Object, BaselineShift>() { // from class: androidx.compose.ui.text.SaversKt$BaselineShiftSaver$2
        @Override // kotlin.jvm.functions.Function1
        /* renamed from: invoke-jTk7eUs, reason: not valid java name and merged with bridge method [inline-methods] */
        public final BaselineShift invoke(Object it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return BaselineShift.m4983boximpl(BaselineShift.m4984constructorimpl(((Float) it).floatValue()));
        }
    });
    private static final Saver<TextRange, Object> TextRangeSaver = SaverKt.Saver(new Function2<SaverScope, TextRange, Object>() { // from class: androidx.compose.ui.text.SaversKt$TextRangeSaver$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(SaverScope saverScope, TextRange textRange) {
            return m4671invokeFDrldGo(saverScope, textRange.getPackedValue());
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* renamed from: invoke-FDrldGo, reason: not valid java name */
        public final Object m4671invokeFDrldGo(SaverScope Saver, long it) {
            Intrinsics.checkNotNullParameter(Saver, "$this$Saver");
            return CollectionsKt.arrayListOf(SaversKt.save(Integer.valueOf(TextRange.m4726getStartimpl(it))), SaversKt.save(Integer.valueOf(TextRange.m4721getEndimpl(it))));
        }
    }, new Function1<Object, TextRange>() { // from class: androidx.compose.ui.text.SaversKt$TextRangeSaver$2
        @Override // kotlin.jvm.functions.Function1
        /* renamed from: invoke-VqIyPBM, reason: not valid java name and merged with bridge method [inline-methods] */
        public final TextRange invoke(Object it) {
            Intrinsics.checkNotNullParameter(it, "it");
            List list = (List) it;
            Object value$iv = list.get(0);
            Object it$iv = value$iv != null ? (Integer) value$iv : null;
            Intrinsics.checkNotNull(it$iv);
            int intValue = ((Number) it$iv).intValue();
            Object value$iv2 = list.get(1);
            Object it$iv2 = value$iv2 != null ? (Integer) value$iv2 : null;
            Intrinsics.checkNotNull(it$iv2);
            return TextRange.m4714boximpl(TextRangeKt.TextRange(intValue, ((Number) it$iv2).intValue()));
        }
    });
    private static final Saver<Shadow, Object> ShadowSaver = SaverKt.Saver(new Function2<SaverScope, Shadow, Object>() { // from class: androidx.compose.ui.text.SaversKt$ShadowSaver$1
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(SaverScope Saver, Shadow it) {
            Intrinsics.checkNotNullParameter(Saver, "$this$Saver");
            Intrinsics.checkNotNullParameter(it, "it");
            return CollectionsKt.arrayListOf(SaversKt.save(Color.m2939boximpl(it.getColor()), SaversKt.getSaver(Color.INSTANCE), Saver), SaversKt.save(Offset.m2699boximpl(it.getOffset()), SaversKt.getSaver(Offset.INSTANCE), Saver), SaversKt.save(Float.valueOf(it.getBlurRadius())));
        }
    }, new Function1<Object, Shadow>() { // from class: androidx.compose.ui.text.SaversKt$ShadowSaver$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function1
        public final Shadow invoke(Object it) {
            Color restore;
            Offset restore2;
            Intrinsics.checkNotNullParameter(it, "it");
            List list = (List) it;
            Object value$iv = list.get(0);
            Saver saver$iv = SaversKt.getSaver(Color.INSTANCE);
            if (Intrinsics.areEqual(value$iv, (Object) false)) {
                restore = null;
            } else {
                restore = value$iv != null ? saver$iv.restore(value$iv) : null;
            }
            Intrinsics.checkNotNull(restore);
            long m2959unboximpl = restore.m2959unboximpl();
            Object value$iv2 = list.get(1);
            Saver saver$iv2 = SaversKt.getSaver(Offset.INSTANCE);
            if (Intrinsics.areEqual(value$iv2, (Object) false)) {
                restore2 = null;
            } else {
                restore2 = value$iv2 != null ? saver$iv2.restore(value$iv2) : null;
            }
            Intrinsics.checkNotNull(restore2);
            long packedValue = restore2.getPackedValue();
            Object value$iv3 = list.get(2);
            Float f = value$iv3 != null ? (Float) value$iv3 : null;
            Intrinsics.checkNotNull(f);
            return new Shadow(m2959unboximpl, packedValue, f.floatValue(), null);
        }
    });
    private static final Saver<Color, Object> ColorSaver = SaverKt.Saver(new Function2<SaverScope, Color, Object>() { // from class: androidx.compose.ui.text.SaversKt$ColorSaver$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(SaverScope saverScope, Color color) {
            return m4667invoke4WTKRHQ(saverScope, color.m2959unboximpl());
        }

        /* renamed from: invoke-4WTKRHQ, reason: not valid java name */
        public final Object m4667invoke4WTKRHQ(SaverScope Saver, long it) {
            Intrinsics.checkNotNullParameter(Saver, "$this$Saver");
            return ULong.m5783boximpl(it);
        }
    }, new Function1<Object, Color>() { // from class: androidx.compose.ui.text.SaversKt$ColorSaver$2
        @Override // kotlin.jvm.functions.Function1
        /* renamed from: invoke-ijrfgN4, reason: not valid java name and merged with bridge method [inline-methods] */
        public final Color invoke(Object it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return Color.m2939boximpl(Color.m2945constructorimpl(((ULong) it).getData()));
        }
    });
    private static final Saver<TextUnit, Object> TextUnitSaver = SaverKt.Saver(new Function2<SaverScope, TextUnit, Object>() { // from class: androidx.compose.ui.text.SaversKt$TextUnitSaver$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(SaverScope saverScope, TextUnit textUnit) {
            return m4673invokempE4wyQ(saverScope, textUnit.getPackedValue());
        }

        /* renamed from: invoke-mpE4wyQ, reason: not valid java name */
        public final Object m4673invokempE4wyQ(SaverScope Saver, long it) {
            Intrinsics.checkNotNullParameter(Saver, "$this$Saver");
            return CollectionsKt.arrayListOf(SaversKt.save(Float.valueOf(TextUnit.m5399getValueimpl(it))), SaversKt.save(TextUnitType.m5424boximpl(TextUnit.m5398getTypeUIouoOA(it))));
        }
    }, new Function1<Object, TextUnit>() { // from class: androidx.compose.ui.text.SaversKt$TextUnitSaver$2
        @Override // kotlin.jvm.functions.Function1
        /* renamed from: invoke-XNhUCwk, reason: not valid java name and merged with bridge method [inline-methods] */
        public final TextUnit invoke(Object it) {
            Intrinsics.checkNotNullParameter(it, "it");
            List list = (List) it;
            Object value$iv = list.get(0);
            Object it$iv = value$iv != null ? (Float) value$iv : null;
            Intrinsics.checkNotNull(it$iv);
            float floatValue = ((Number) it$iv).floatValue();
            Object value$iv2 = list.get(1);
            TextUnitType textUnitType = value$iv2 != null ? (TextUnitType) value$iv2 : null;
            Intrinsics.checkNotNull(textUnitType);
            return TextUnit.m5389boximpl(TextUnitKt.m5411TextUnitanM5pPY(floatValue, textUnitType.getType()));
        }
    });
    private static final Saver<Offset, Object> OffsetSaver = SaverKt.Saver(new Function2<SaverScope, Offset, Object>() { // from class: androidx.compose.ui.text.SaversKt$OffsetSaver$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(SaverScope saverScope, Offset offset) {
            return m4669invokeUv8p0NA(saverScope, offset.getPackedValue());
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* renamed from: invoke-Uv8p0NA, reason: not valid java name */
        public final Object m4669invokeUv8p0NA(SaverScope Saver, long it) {
            Intrinsics.checkNotNullParameter(Saver, "$this$Saver");
            return Offset.m2707equalsimpl0(it, Offset.INSTANCE.m2725getUnspecifiedF1C5BW0()) ? (Serializable) false : CollectionsKt.arrayListOf(SaversKt.save(Float.valueOf(Offset.m2710getXimpl(it))), SaversKt.save(Float.valueOf(Offset.m2711getYimpl(it))));
        }
    }, new Function1<Object, Offset>() { // from class: androidx.compose.ui.text.SaversKt$OffsetSaver$2
        @Override // kotlin.jvm.functions.Function1
        /* renamed from: invoke-x-9fifI, reason: not valid java name and merged with bridge method [inline-methods] */
        public final Offset invoke(Object it) {
            Intrinsics.checkNotNullParameter(it, "it");
            if (Intrinsics.areEqual(it, (Object) false)) {
                return Offset.m2699boximpl(Offset.INSTANCE.m2725getUnspecifiedF1C5BW0());
            }
            List list = (List) it;
            Object value$iv = list.get(0);
            Object it$iv = value$iv != null ? (Float) value$iv : null;
            Intrinsics.checkNotNull(it$iv);
            float floatValue = ((Number) it$iv).floatValue();
            Object value$iv2 = list.get(1);
            Object it$iv2 = value$iv2 != null ? (Float) value$iv2 : null;
            Intrinsics.checkNotNull(it$iv2);
            return Offset.m2699boximpl(OffsetKt.Offset(floatValue, ((Number) it$iv2).floatValue()));
        }
    });
    private static final Saver<LocaleList, Object> LocaleListSaver = SaverKt.Saver(new Function2<SaverScope, LocaleList, Object>() { // from class: androidx.compose.ui.text.SaversKt$LocaleListSaver$1
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(SaverScope Saver, LocaleList it) {
            Intrinsics.checkNotNullParameter(Saver, "$this$Saver");
            Intrinsics.checkNotNullParameter(it, "it");
            List $this$fastMap$iv = it.getLocaleList();
            List target$iv = new ArrayList($this$fastMap$iv.size());
            int size = $this$fastMap$iv.size();
            for (int index$iv$iv = 0; index$iv$iv < size; index$iv$iv++) {
                Object item$iv$iv = $this$fastMap$iv.get(index$iv$iv);
                Locale locale = (Locale) item$iv$iv;
                target$iv.add(SaversKt.save(locale, SaversKt.getSaver(Locale.INSTANCE), Saver));
            }
            return target$iv;
        }
    }, new Function1<Object, LocaleList>() { // from class: androidx.compose.ui.text.SaversKt$LocaleListSaver$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function1
        public final LocaleList invoke(Object it) {
            Locale locale;
            Intrinsics.checkNotNullParameter(it, "it");
            List list = (List) it;
            ArrayList target$iv = new ArrayList(list.size());
            int size = list.size();
            for (int index$iv$iv = 0; index$iv$iv < size; index$iv$iv++) {
                Object item$iv$iv = list.get(index$iv$iv);
                ArrayList arrayList = target$iv;
                Saver saver$iv = SaversKt.getSaver(Locale.INSTANCE);
                if (Intrinsics.areEqual(item$iv$iv, (Object) false)) {
                    locale = null;
                } else if (item$iv$iv != null) {
                    Object it$iv = saver$iv.restore(item$iv$iv);
                    locale = (Locale) it$iv;
                } else {
                    locale = null;
                }
                Intrinsics.checkNotNull(locale);
                arrayList.add(locale);
            }
            return new LocaleList(target$iv);
        }
    });
    private static final Saver<Locale, Object> LocaleSaver = SaverKt.Saver(new Function2<SaverScope, Locale, Object>() { // from class: androidx.compose.ui.text.SaversKt$LocaleSaver$1
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(SaverScope Saver, Locale it) {
            Intrinsics.checkNotNullParameter(Saver, "$this$Saver");
            Intrinsics.checkNotNullParameter(it, "it");
            return it.toLanguageTag();
        }
    }, new Function1<Object, Locale>() { // from class: androidx.compose.ui.text.SaversKt$LocaleSaver$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function1
        public final Locale invoke(Object it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return new Locale((String) it);
        }
    });

    private static /* synthetic */ void getAnnotationRangeSaver$annotations() {
    }

    private static /* synthetic */ void getTextUnitSaver$annotations() {
    }

    private static /* synthetic */ void getUrlAnnotationSaver$annotations() {
    }

    public static final <T extends Saver<Original, Saveable>, Original, Saveable> Object save(Original original, T saver, SaverScope scope) {
        Object save;
        Intrinsics.checkNotNullParameter(saver, "saver");
        Intrinsics.checkNotNullParameter(scope, "scope");
        if (original == null || (save = saver.save(scope, original)) == null) {
            return false;
        }
        return save;
    }

    public static final /* synthetic */ <T extends Saver<Original, Saveable>, Original, Saveable, Result> Result restore(Saveable saveable, T saver) {
        Intrinsics.checkNotNullParameter(saver, "saver");
        if (Intrinsics.areEqual((Object) saveable, (Object) false) || saveable == null) {
            return null;
        }
        Result result = (Result) saver.restore(saveable);
        Intrinsics.reifiedOperationMarker(1, "Result");
        return result;
    }

    public static final <T> T save(T t) {
        return t;
    }

    public static final /* synthetic */ <Result> Result restore(Object obj) {
        if (obj == null) {
            return null;
        }
        Intrinsics.reifiedOperationMarker(1, "Result");
        return (Result) obj;
    }

    public static final Saver<AnnotatedString, Object> getAnnotatedStringSaver() {
        return AnnotatedStringSaver;
    }

    public static final Saver<ParagraphStyle, Object> getParagraphStyleSaver() {
        return ParagraphStyleSaver;
    }

    public static final Saver<SpanStyle, Object> getSpanStyleSaver() {
        return SpanStyleSaver;
    }

    public static final Saver<TextDecoration, Object> getSaver(TextDecoration.Companion $this$Saver) {
        Intrinsics.checkNotNullParameter($this$Saver, "<this>");
        return TextDecorationSaver;
    }

    public static final Saver<TextGeometricTransform, Object> getSaver(TextGeometricTransform.Companion $this$Saver) {
        Intrinsics.checkNotNullParameter($this$Saver, "<this>");
        return TextGeometricTransformSaver;
    }

    public static final Saver<TextIndent, Object> getSaver(TextIndent.Companion $this$Saver) {
        Intrinsics.checkNotNullParameter($this$Saver, "<this>");
        return TextIndentSaver;
    }

    public static final Saver<FontWeight, Object> getSaver(FontWeight.Companion $this$Saver) {
        Intrinsics.checkNotNullParameter($this$Saver, "<this>");
        return FontWeightSaver;
    }

    public static final Saver<BaselineShift, Object> getSaver(BaselineShift.Companion $this$Saver) {
        Intrinsics.checkNotNullParameter($this$Saver, "<this>");
        return BaselineShiftSaver;
    }

    public static final Saver<TextRange, Object> getSaver(TextRange.Companion $this$Saver) {
        Intrinsics.checkNotNullParameter($this$Saver, "<this>");
        return TextRangeSaver;
    }

    public static final Saver<Shadow, Object> getSaver(Shadow.Companion $this$Saver) {
        Intrinsics.checkNotNullParameter($this$Saver, "<this>");
        return ShadowSaver;
    }

    public static final Saver<Color, Object> getSaver(Color.Companion $this$Saver) {
        Intrinsics.checkNotNullParameter($this$Saver, "<this>");
        return ColorSaver;
    }

    public static final Saver<TextUnit, Object> getSaver(TextUnit.Companion $this$Saver) {
        Intrinsics.checkNotNullParameter($this$Saver, "<this>");
        return TextUnitSaver;
    }

    public static final Saver<Offset, Object> getSaver(Offset.Companion $this$Saver) {
        Intrinsics.checkNotNullParameter($this$Saver, "<this>");
        return OffsetSaver;
    }

    public static final Saver<LocaleList, Object> getSaver(LocaleList.Companion $this$Saver) {
        Intrinsics.checkNotNullParameter($this$Saver, "<this>");
        return LocaleListSaver;
    }

    public static final Saver<Locale, Object> getSaver(Locale.Companion $this$Saver) {
        Intrinsics.checkNotNullParameter($this$Saver, "<this>");
        return LocaleSaver;
    }
}
