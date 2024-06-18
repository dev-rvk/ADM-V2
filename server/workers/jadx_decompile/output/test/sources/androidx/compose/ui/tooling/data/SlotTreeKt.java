package androidx.compose.ui.tooling.data;

import androidx.autofill.HintConstants;
import androidx.compose.runtime.tooling.CompositionData;
import androidx.compose.runtime.tooling.CompositionGroup;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.layout.LayoutInfo;
import androidx.compose.ui.unit.IntRect;
import androidx.compose.ui.unit.IntSize;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.math.MathKt;
import kotlin.text.CharsKt;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* compiled from: SlotTree.kt */
@Metadata(d1 = {"\u0000\u008a\u0001\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u001a\u0010\u0010!\u001a\u00020\t2\u0006\u0010\"\u001a\u00020#H\u0002\u001a(\u0010$\u001a\b\u0012\u0004\u0012\u00020&0%2\u000e\u0010'\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010(0%2\b\u0010)\u001a\u0004\u0018\u00010*H\u0003\u001a\u0014\u0010+\u001a\u0004\u0018\u00010\u00062\b\u0010,\u001a\u0004\u0018\u00010(H\u0003\u001a\u0016\u0010-\u001a\b\u0012\u0004\u0012\u00020.0%2\u0006\u0010/\u001a\u00020\u0006H\u0002\u001a\u001e\u00100\u001a\u0004\u0018\u00010*2\u0006\u00101\u001a\u00020\u00062\n\b\u0002\u00102\u001a\u0004\u0018\u00010*H\u0003\u001a\u001a\u00103\u001a\u0004\u0018\u000104*\u0006\u0012\u0002\b\u0003052\u0006\u00106\u001a\u00020\u0006H\u0002\u001a\f\u00107\u001a\u00020\u0019*\u000208H\u0007\u001a\f\u00109\u001a\u00020\u0006*\u00020\u0015H\u0002\u001a\u001e\u0010:\u001a\b\u0012\u0004\u0012\u00020&0%*\u00020;2\n\b\u0002\u0010<\u001a\u0004\u0018\u00010=H\u0007\u001a\u0016\u0010>\u001a\u00020\u0019*\u00020;2\b\u0010?\u001a\u0004\u0018\u00010*H\u0003\u001a\f\u0010@\u001a\u00020\u0014*\u00020\u0015H\u0002\u001a\u0014\u0010A\u001a\u00020\u0014*\u00020\u00152\u0006\u0010B\u001a\u00020\u0006H\u0002\u001a\f\u0010C\u001a\u00020\u0014*\u00020\u0015H\u0002\u001a\f\u0010D\u001a\u00020\u0014*\u00020\u0015H\u0002\u001a\f\u0010E\u001a\u00020\u0014*\u00020\u0015H\u0002\u001aK\u0010F\u001a\u0004\u0018\u0001HG\"\u0004\b\u0000\u0010G*\u0002082&\u0010H\u001a\"\u0012\u0004\u0012\u00020;\u0012\u0004\u0012\u00020J\u0012\n\u0012\b\u0012\u0004\u0012\u0002HG0%\u0012\u0006\u0012\u0004\u0018\u0001HG0I2\b\b\u0002\u0010<\u001a\u00020=H\u0007¢\u0006\u0002\u0010K\u001a\f\u0010L\u001a\u00020\u0001*\u00020\u0015H\u0002\u001a\f\u0010M\u001a\u00020\u0001*\u00020\u0006H\u0002\u001a\u0014\u0010M\u001a\u00020\u0001*\u00020\u00062\u0006\u0010N\u001a\u00020\u0001H\u0002\u001a\u001c\u0010O\u001a\u00020\u0006*\u00020\u00062\u0006\u0010P\u001a\u00020\u00062\u0006\u0010Q\u001a\u00020\u0006H\u0002\u001a\u0014\u0010R\u001a\u00020\t*\u00020\t2\u0006\u0010S\u001a\u00020\tH\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000\"\u0014\u0010\b\u001a\u00020\tX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u000e\u0010\f\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\r\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000e\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0011\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0012\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0018\u0010\u0013\u001a\u00020\u0014*\u00020\u00158BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0016\"\u0018\u0010\u0017\u001a\u00020\u0014*\u00020\u00158BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0016\" \u0010\u0018\u001a\u0004\u0018\u00010\u0006*\u00020\u00198GX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0018\u0010\u001e\u001a\u00020\u0006*\u00020\u00158BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010 ¨\u0006T"}, d2 = {"BITS_PER_SLOT", "", "SLOT_MASK", "STABLE_BITS", "STATIC_BITS", "changedFieldName", "", "defaultFieldName", "emptyBox", "Landroidx/compose/ui/unit/IntRect;", "getEmptyBox", "()Landroidx/compose/ui/unit/IntRect;", "internalFieldPrefix", "jacocoDataField", "parameterPrefix", "parametersInformationTokenizer", "Lkotlin/text/Regex;", "recomposeScopeNameSuffix", "tokenizer", "isANumber", "", "Lkotlin/text/MatchResult;", "(Lkotlin/text/MatchResult;)Z", "isClassName", "position", "Landroidx/compose/ui/tooling/data/Group;", "getPosition$annotations", "(Landroidx/compose/ui/tooling/data/Group;)V", "getPosition", "(Landroidx/compose/ui/tooling/data/Group;)Ljava/lang/String;", "text", "getText", "(Lkotlin/text/MatchResult;)Ljava/lang/String;", "boundsOfLayoutNode", "node", "Landroidx/compose/ui/layout/LayoutInfo;", "extractParameterInfo", "", "Landroidx/compose/ui/tooling/data/ParameterInformation;", "data", "", "context", "Landroidx/compose/ui/tooling/data/SourceInformationContext;", "keyPosition", "key", "parseParameters", "Landroidx/compose/ui/tooling/data/Parameter;", "parameters", "sourceInformationContextOf", "information", "parent", "accessibleField", "Ljava/lang/reflect/Field;", "Ljava/lang/Class;", HintConstants.AUTOFILL_HINT_NAME, "asTree", "Landroidx/compose/runtime/tooling/CompositionData;", "callName", "findParameters", "Landroidx/compose/runtime/tooling/CompositionGroup;", "cache", "Landroidx/compose/ui/tooling/data/ContextCache;", "getGroup", "parentContext", "isCallWithName", "isChar", "c", "isFileName", "isNumber", "isParameterInformation", "mapTree", "T", "factory", "Lkotlin/Function3;", "Landroidx/compose/ui/tooling/data/SourceContext;", "(Landroidx/compose/runtime/tooling/CompositionData;Lkotlin/jvm/functions/Function3;Landroidx/compose/ui/tooling/data/ContextCache;)Ljava/lang/Object;", "number", "parseToInt", "radix", "replacePrefix", "prefix", "replacement", "union", "other", "ui-tooling-data_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class SlotTreeKt {
    private static final int BITS_PER_SLOT = 3;
    private static final int SLOT_MASK = 7;
    private static final int STABLE_BITS = 4;
    private static final int STATIC_BITS = 3;
    private static final String changedFieldName = "$$changed";
    private static final String defaultFieldName = "$$default";
    private static final String internalFieldPrefix = "$$";
    private static final String jacocoDataField = "$jacoco";
    private static final String parameterPrefix = "$";
    private static final String recomposeScopeNameSuffix = ".RecomposeScopeImpl";
    private static final IntRect emptyBox = new IntRect(0, 0, 0, 0);
    private static final Regex tokenizer = new Regex("(\\d+)|([,])|([*])|([:])|L|(P\\([^)]*\\))|(C(\\(([^)]*)\\))?)|@");
    private static final Regex parametersInformationTokenizer = new Regex("(\\d+)|,|[!P()]|:([^,!)]+)");

    public static /* synthetic */ void getPosition$annotations(Group group) {
    }

    public static final IntRect getEmptyBox() {
        return emptyBox;
    }

    private static final boolean isNumber(MatchResult $this$isNumber) {
        return $this$isNumber.getGroups().get(1) != null;
    }

    private static final int number(MatchResult $this$number) {
        return parseToInt($this$number.getGroupValues().get(1));
    }

    private static final String getText(MatchResult $this$text) {
        return $this$text.getGroupValues().get(0);
    }

    private static final boolean isChar(MatchResult $this$isChar, String c) {
        return Intrinsics.areEqual(getText($this$isChar), c);
    }

    private static final boolean isFileName(MatchResult $this$isFileName) {
        return $this$isFileName.getGroups().get(4) != null;
    }

    private static final boolean isParameterInformation(MatchResult $this$isParameterInformation) {
        return $this$isParameterInformation.getGroups().get(5) != null;
    }

    private static final boolean isCallWithName(MatchResult $this$isCallWithName) {
        return $this$isCallWithName.getGroups().get(6) != null;
    }

    private static final String callName(MatchResult $this$callName) {
        return $this$callName.getGroupValues().get(8);
    }

    private static final boolean isANumber(MatchResult $this$isANumber) {
        return $this$isANumber.getGroups().get(1) != null;
    }

    private static final boolean isClassName(MatchResult $this$isClassName) {
        return $this$isClassName.getGroups().get(2) != null;
    }

    private static final int parseToInt(String $this$parseToInt) {
        try {
            return Integer.parseInt($this$parseToInt);
        } catch (NumberFormatException e) {
            throw new ParseError();
        }
    }

    private static final int parseToInt(String $this$parseToInt, int radix) {
        try {
            return Integer.parseInt($this$parseToInt, CharsKt.checkRadix(radix));
        } catch (NumberFormatException e) {
            throw new ParseError();
        }
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [kotlin.text.MatchResult, T] */
    private static final List<Parameter> parseParameters(String parameters) {
        String inlineClass;
        Ref.ObjectRef currentResult = new Ref.ObjectRef();
        currentResult.element = Regex.find$default(parametersInformationTokenizer, parameters, 0, 2, null);
        List expectedSortedIndex = CollectionsKt.mutableListOf(0, 1, 2, 3);
        Ref.IntRef lastAdded = new Ref.IntRef();
        lastAdded.element = expectedSortedIndex.size() - 1;
        List result = new ArrayList();
        try {
            parseParameters$expect(currentResult, "P");
            parseParameters$expect(currentResult, "(");
            while (!parseParameters$isChar(currentResult, ")")) {
                if (parseParameters$isChar(currentResult, "!")) {
                    parseParameters$next(currentResult);
                    int count = parseParameters$expectNumber(currentResult);
                    parseParameters$ensureIndexes(lastAdded, expectedSortedIndex, result.size() + count);
                    for (int i = 0; i < count; i++) {
                        result.add(new Parameter(((Number) CollectionsKt.first(expectedSortedIndex)).intValue(), null, 2, null));
                        expectedSortedIndex.remove(0);
                    }
                } else if (parseParameters$isChar(currentResult, ",")) {
                    parseParameters$next(currentResult);
                } else {
                    int index = parseParameters$expectNumber(currentResult);
                    if (parseParameters$isClassName(currentResult)) {
                        inlineClass = parseParameters$expectClassName(currentResult);
                    } else {
                        inlineClass = null;
                    }
                    result.add(new Parameter(index, inlineClass));
                    parseParameters$ensureIndexes(lastAdded, expectedSortedIndex, index);
                    expectedSortedIndex.remove(Integer.valueOf(index));
                }
            }
            parseParameters$expect(currentResult, ")");
            while (expectedSortedIndex.size() > 0) {
                result.add(new Parameter(((Number) CollectionsKt.first(expectedSortedIndex)).intValue(), null, 2, null));
                expectedSortedIndex.remove(0);
            }
            return result;
        } catch (ParseError e) {
            return CollectionsKt.emptyList();
        } catch (NumberFormatException e2) {
            return CollectionsKt.emptyList();
        }
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [kotlin.text.MatchResult, T] */
    private static final MatchResult parseParameters$next(Ref.ObjectRef<MatchResult> objectRef) {
        MatchResult it = objectRef.element;
        if (it != null) {
            objectRef.element = it.next();
        }
        return objectRef.element;
    }

    private static final int parseParameters$expectNumber(Ref.ObjectRef<MatchResult> objectRef) {
        MatchResult mr = objectRef.element;
        if (mr == null || !isANumber(mr)) {
            throw new ParseError();
        }
        parseParameters$next(objectRef);
        return parseToInt(getText(mr));
    }

    private static final String parseParameters$expectClassName(Ref.ObjectRef<MatchResult> objectRef) {
        MatchResult mr = objectRef.element;
        if (mr == null || !isClassName(mr)) {
            throw new ParseError();
        }
        parseParameters$next(objectRef);
        String substring = getText(mr).substring(1);
        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
        return replacePrefix(substring, "c#", "androidx.compose.");
    }

    private static final void parseParameters$expect(Ref.ObjectRef<MatchResult> objectRef, String value) {
        MatchResult mr = objectRef.element;
        if (mr == null || !Intrinsics.areEqual(getText(mr), value)) {
            throw new ParseError();
        }
        parseParameters$next(objectRef);
    }

    private static final boolean parseParameters$isChar(Ref.ObjectRef<MatchResult> objectRef, String value) {
        MatchResult mr = objectRef.element;
        return mr == null || Intrinsics.areEqual(getText(mr), value);
    }

    private static final boolean parseParameters$isClassName(Ref.ObjectRef<MatchResult> objectRef) {
        MatchResult mr = objectRef.element;
        return mr != null && isClassName(mr);
    }

    private static final void parseParameters$ensureIndexes(Ref.IntRef lastAdded, List<Integer> list, int index) {
        int missing = index - lastAdded.element;
        if (missing > 0) {
            int amountToAdd = missing < 4 ? 4 : missing;
            for (int i = 0; i < amountToAdd; i++) {
                int it = i;
                list.add(Integer.valueOf(lastAdded.element + it + 1));
            }
            lastAdded.element += amountToAdd;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ SourceInformationContext sourceInformationContextOf$default(String str, SourceInformationContext sourceInformationContext, int i, Object obj) {
        if ((i & 2) != 0) {
            sourceInformationContext = null;
        }
        return sourceInformationContextOf(str, sourceInformationContext);
    }

    /* JADX WARN: Removed duplicated region for block: B:47:0x011f  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0127  */
    /* JADX WARN: Type inference failed for: r0v2, types: [kotlin.text.MatchResult, T] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static final androidx.compose.ui.tooling.data.SourceInformationContext sourceInformationContextOf(java.lang.String r21, androidx.compose.ui.tooling.data.SourceInformationContext r22) {
        /*
            Method dump skipped, instructions count: 329
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.tooling.data.SlotTreeKt.sourceInformationContextOf(java.lang.String, androidx.compose.ui.tooling.data.SourceInformationContext):androidx.compose.ui.tooling.data.SourceInformationContext");
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [kotlin.text.MatchResult, T] */
    private static final MatchResult sourceInformationContextOf$next$4(Ref.ObjectRef<MatchResult> objectRef) {
        MatchResult it = objectRef.element;
        if (it != null) {
            objectRef.element = it.next();
        }
        return objectRef.element;
    }

    private static final SourceLocationInfo sourceInformationContextOf$parseLocation(Ref.ObjectRef<MatchResult> objectRef) {
        Integer lineNumber = null;
        Integer offset = null;
        Integer length = null;
        try {
            MatchResult mr = objectRef.element;
            if (mr != null && isNumber(mr)) {
                lineNumber = Integer.valueOf(number(mr) + 1);
                mr = sourceInformationContextOf$next$4(objectRef);
            }
            if (mr != null && isChar(mr, "@")) {
                MatchResult mr2 = sourceInformationContextOf$next$4(objectRef);
                if (mr2 != null && isNumber(mr2)) {
                    offset = Integer.valueOf(number(mr2));
                    MatchResult mr3 = sourceInformationContextOf$next$4(objectRef);
                    if (mr3 != null && isChar(mr3, "L")) {
                        MatchResult mr4 = sourceInformationContextOf$next$4(objectRef);
                        if (mr4 != null && isNumber(mr4)) {
                            length = Integer.valueOf(number(mr4));
                        }
                        return null;
                    }
                }
                return null;
            }
            if (lineNumber == null || offset == null || length == null) {
                return null;
            }
            return new SourceLocationInfo(lineNumber, offset, length);
        } catch (ParseError e) {
            return null;
        }
    }

    private static final Group getGroup(CompositionGroup $this$getGroup, SourceInformationContext parentContext) {
        IntRect box;
        Object key = $this$getGroup.getKey();
        String it = $this$getGroup.getSourceInfo();
        Object obj = null;
        SourceInformationContext context = it != null ? sourceInformationContextOf(it, parentContext) : null;
        Object node = $this$getGroup.getNode();
        List data = new ArrayList();
        List children = new ArrayList();
        CollectionsKt.addAll(data, $this$getGroup.getData());
        for (CompositionGroup child : $this$getGroup.getCompositionGroups()) {
            children.add(getGroup(child, context));
        }
        List modifierInfo = node instanceof LayoutInfo ? ((LayoutInfo) node).getModifierInfo() : CollectionsKt.emptyList();
        if (node instanceof LayoutInfo) {
            box = boundsOfLayoutNode((LayoutInfo) node);
        } else if (children.isEmpty()) {
            box = emptyBox;
        } else {
            List $this$map$iv = children;
            Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
            for (Object item$iv$iv : $this$map$iv) {
                Group g = (Group) item$iv$iv;
                destination$iv$iv.add(g.getBox());
            }
            Iterable $this$reduce$iv = (List) destination$iv$iv;
            Iterator iterator$iv = $this$reduce$iv.iterator();
            if (!iterator$iv.hasNext()) {
                throw new UnsupportedOperationException("Empty collection can't be reduced.");
            }
            Object accumulator$iv = iterator$iv.next();
            while (iterator$iv.hasNext()) {
                IntRect box2 = (IntRect) iterator$iv.next();
                IntRect acc = (IntRect) accumulator$iv;
                accumulator$iv = union(box2, acc);
            }
            box = (IntRect) accumulator$iv;
        }
        boolean z = false;
        SourceLocation location = (!(context != null && context.getIsCall()) || parentContext == null) ? null : parentContext.nextSourceLocation();
        if (node != null) {
            return new NodeGroup(key, node, box, data, modifierInfo, children);
        }
        String name = context != null ? context.getName() : null;
        String name2 = context != null ? context.getName() : null;
        if (!(name2 == null || name2.length() == 0) && (box.getBottom() - box.getTop() > 0 || box.getRight() - box.getLeft() > 0)) {
            obj = $this$getGroup.getIdentity();
        }
        List<ParameterInformation> extractParameterInfo = extractParameterInfo(data, context);
        List list = data;
        List list2 = children;
        if (context != null && context.getIsInline()) {
            z = true;
        }
        return new CallGroup(key, name, box, location, obj, extractParameterInfo, list, list2, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final IntRect boundsOfLayoutNode(LayoutInfo node) {
        if (!node.isAttached()) {
            return new IntRect(0, 0, node.getWidth(), node.getHeight());
        }
        long position = LayoutCoordinatesKt.positionInWindow(node.getCoordinates());
        long size = node.getCoordinates().mo4193getSizeYbymL2g();
        int left = MathKt.roundToInt(Offset.m2710getXimpl(position));
        int top = MathKt.roundToInt(Offset.m2711getYimpl(position));
        int right = IntSize.m5378getWidthimpl(size) + left;
        int bottom = IntSize.m5377getHeightimpl(size) + top;
        return new IntRect(left, top, right, bottom);
    }

    public static /* synthetic */ Object mapTree$default(CompositionData compositionData, Function3 function3, ContextCache contextCache, int i, Object obj) {
        if ((i & 2) != 0) {
            contextCache = new ContextCache();
        }
        return mapTree(compositionData, function3, contextCache);
    }

    public static final <T> T mapTree(CompositionData compositionData, Function3<? super CompositionGroup, ? super SourceContext, ? super List<? extends T>, ? extends T> factory, ContextCache cache) {
        Intrinsics.checkNotNullParameter(compositionData, "<this>");
        Intrinsics.checkNotNullParameter(factory, "factory");
        Intrinsics.checkNotNullParameter(cache, "cache");
        CompositionGroup compositionGroup = (CompositionGroup) CollectionsKt.firstOrNull(compositionData.getCompositionGroups());
        if (compositionGroup == null) {
            return null;
        }
        CompositionCallStack compositionCallStack = new CompositionCallStack(factory, cache.getContexts$ui_tooling_data_release());
        ArrayList arrayList = new ArrayList();
        compositionCallStack.convert(compositionGroup, 0, arrayList);
        return (T) CollectionsKt.firstOrNull((List) arrayList);
    }

    public static /* synthetic */ List findParameters$default(CompositionGroup compositionGroup, ContextCache contextCache, int i, Object obj) {
        if ((i & 1) != 0) {
            contextCache = null;
        }
        return findParameters(compositionGroup, contextCache);
    }

    public static final List<ParameterInformation> findParameters(CompositionGroup $this$findParameters, ContextCache cache) {
        Object answer$iv;
        Intrinsics.checkNotNullParameter($this$findParameters, "<this>");
        String information = $this$findParameters.getSourceInfo();
        if (information == null) {
            return CollectionsKt.emptyList();
        }
        SourceInformationContext sourceInformationContext = null;
        if (cache == null) {
            sourceInformationContext = sourceInformationContextOf$default(information, null, 2, null);
        } else {
            Map $this$getOrPut$iv = cache.getContexts$ui_tooling_data_release();
            Object value$iv = $this$getOrPut$iv.get(information);
            if (value$iv == null) {
                answer$iv = sourceInformationContextOf$default(information, null, 2, null);
                $this$getOrPut$iv.put(information, answer$iv);
            } else {
                answer$iv = value$iv;
            }
            if (answer$iv instanceof SourceInformationContext) {
                sourceInformationContext = (SourceInformationContext) answer$iv;
            }
        }
        SourceInformationContext context = sourceInformationContext;
        List data = new ArrayList();
        CollectionsKt.addAll(data, $this$findParameters.getData());
        return extractParameterInfo(data, context);
    }

    public static final Group asTree(CompositionData $this$asTree) {
        Group group;
        Intrinsics.checkNotNullParameter($this$asTree, "<this>");
        CompositionGroup compositionGroup = (CompositionGroup) CollectionsKt.firstOrNull($this$asTree.getCompositionGroups());
        return (compositionGroup == null || (group = getGroup(compositionGroup, null)) == null) ? EmptyGroup.INSTANCE : group;
    }

    public static final IntRect union(IntRect $this$union, IntRect other) {
        Intrinsics.checkNotNullParameter($this$union, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        if (Intrinsics.areEqual($this$union, emptyBox)) {
            return other;
        }
        if (Intrinsics.areEqual(other, emptyBox)) {
            return $this$union;
        }
        return new IntRect(Math.min($this$union.getLeft(), other.getLeft()), Math.min($this$union.getTop(), other.getTop()), Math.max($this$union.getRight(), other.getRight()), Math.max($this$union.getBottom(), other.getBottom()));
    }

    private static final String keyPosition(Object key) {
        if (key instanceof String) {
            return (String) key;
        }
        if (key instanceof JoinedKey) {
            String keyPosition = keyPosition(((JoinedKey) key).getLeft());
            if (keyPosition == null) {
                return keyPosition(((JoinedKey) key).getRight());
            }
            return keyPosition;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:104:? A[LOOP:0: B:4:0x0018->B:104:?, LOOP_END, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0046 A[EDGE_INSN: B:13:0x0046->B:14:0x0046 BREAK  A[LOOP:0: B:4:0x0018->B:104:?], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x010b A[Catch: all -> 0x0208, TryCatch #1 {all -> 0x0208, blocks: (B:33:0x00c4, B:35:0x00de, B:37:0x00f0, B:41:0x010b, B:43:0x010e, B:51:0x011c, B:53:0x0143, B:55:0x014d, B:57:0x0154, B:59:0x015c, B:60:0x016c, B:62:0x0177, B:65:0x0192, B:68:0x01ad, B:71:0x01b4, B:74:0x01bd, B:78:0x01e4, B:88:0x0165, B:93:0x0149), top: B:32:0x00c4 }] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x010e A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.util.List<androidx.compose.ui.tooling.data.ParameterInformation> extractParameterInfo(java.util.List<? extends java.lang.Object> r36, androidx.compose.ui.tooling.data.SourceInformationContext r37) {
        /*
            Method dump skipped, instructions count: 543
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.tooling.data.SlotTreeKt.extractParameterInfo(java.util.List, androidx.compose.ui.tooling.data.SourceInformationContext):java.util.List");
    }

    public static final String getPosition(Group $this$position) {
        Intrinsics.checkNotNullParameter($this$position, "<this>");
        return keyPosition($this$position.getKey());
    }

    private static final Field accessibleField(Class<?> cls, String name) {
        Object element$iv;
        Object[] declaredFields = cls.getDeclaredFields();
        Intrinsics.checkNotNullExpressionValue(declaredFields, "declaredFields");
        Object[] $this$firstOrNull$iv = declaredFields;
        int length = $this$firstOrNull$iv.length;
        int i = 0;
        while (true) {
            if (i < length) {
                element$iv = $this$firstOrNull$iv[i];
                Field it = (Field) element$iv;
                if (Intrinsics.areEqual(it.getName(), name)) {
                    break;
                }
                i++;
            } else {
                element$iv = null;
                break;
            }
        }
        Field $this$accessibleField_u24lambda_u2415 = (Field) element$iv;
        if ($this$accessibleField_u24lambda_u2415 == null) {
            return null;
        }
        $this$accessibleField_u24lambda_u2415.setAccessible(true);
        return $this$accessibleField_u24lambda_u2415;
    }

    private static final String replacePrefix(String $this$replacePrefix, String prefix, String replacement) {
        if (!StringsKt.startsWith$default($this$replacePrefix, prefix, false, 2, (Object) null)) {
            return $this$replacePrefix;
        }
        StringBuilder append = new StringBuilder().append(replacement);
        String substring = $this$replacePrefix.substring(prefix.length());
        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
        return append.append(substring).toString();
    }
}
