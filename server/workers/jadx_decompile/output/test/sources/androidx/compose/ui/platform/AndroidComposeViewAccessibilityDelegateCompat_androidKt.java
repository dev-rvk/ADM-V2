package androidx.compose.ui.platform;

import android.graphics.Region;
import android.view.View;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.layout.LayoutInfo;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat;
import androidx.compose.ui.semantics.AccessibilityAction;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.semantics.SemanticsActions;
import androidx.compose.ui.semantics.SemanticsConfiguration;
import androidx.compose.ui.semantics.SemanticsConfigurationKt;
import androidx.compose.ui.semantics.SemanticsNode;
import androidx.compose.ui.semantics.SemanticsOwner;
import androidx.compose.ui.semantics.SemanticsProperties;
import androidx.compose.ui.semantics.SemanticsPropertyKey;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.viewinterop.AndroidViewHolder;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* compiled from: AndroidComposeViewAccessibilityDelegateCompat.android.kt */
@Metadata(d1 = {"\u0000z\n\u0000\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001a\u0010\u0013\u001a\u00020\n*\u0006\u0012\u0002\b\u00030\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0002\u001a\f\u0010\u0017\u001a\u00020\n*\u00020\u0002H\u0002\u001a\f\u0010\u0018\u001a\u00020\n*\u00020\u0002H\u0002\u001a\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u001a*\b\u0012\u0004\u0012\u00020\u001a0\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0000\u001a\"\u0010\u001e\u001a\u0004\u0018\u00010\u001f*\u00020\u001f2\u0012\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\n0!H\u0002\u001a\u0018\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020$0#*\u00020%H\u0000\u001a\f\u0010&\u001a\u00020\n*\u00020\u0002H\u0002\u001a \u0010'\u001a\u00020\n*\b\u0012\u0004\u0012\u00020\u00010(2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00010(H\u0002\u001a\u0014\u0010*\u001a\u00020\n*\u00020\u00022\u0006\u0010+\u001a\u00020,H\u0002\u001a\u001b\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00010(*\u00020\u00012\u0006\u0010.\u001a\u00020\u0001H\u0080\u0002\u001a\u0016\u0010/\u001a\u0004\u0018\u000100*\u0002012\u0006\u0010\u001c\u001a\u00020\u001dH\u0000\u001a\u001b\u00102\u001a\u0004\u0018\u00010\u0006*\u000203H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b4\u00105\"\u0018\u0010\u0000\u001a\u00020\u0001*\u00020\u00028BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u0006*\u00020\u00028BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b\"\u0018\u0010\t\u001a\u00020\n*\u00020\u00028BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u000b\"\u0018\u0010\f\u001a\u00020\n*\u00020\u00028BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\u000b\"\u0018\u0010\r\u001a\u00020\n*\u00020\u00028BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000b\"\u001a\u0010\u000e\u001a\u0004\u0018\u00010\n*\u00020\u00028BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f\"\u001e\u0010\u0010\u001a\u00020\n*\u00020\u00028BX\u0082\u0004¢\u0006\f\u0012\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0010\u0010\u000b\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u00066"}, d2 = {"getTraversalIndex", "", "Landroidx/compose/ui/semantics/SemanticsNode;", "getGetTraversalIndex", "(Landroidx/compose/ui/semantics/SemanticsNode;)F", "infoContentDescriptionOrNull", "", "getInfoContentDescriptionOrNull", "(Landroidx/compose/ui/semantics/SemanticsNode;)Ljava/lang/String;", "isPassword", "", "(Landroidx/compose/ui/semantics/SemanticsNode;)Z", "isRtl", "isTextField", "isTraversalGroup", "(Landroidx/compose/ui/semantics/SemanticsNode;)Ljava/lang/Boolean;", "isVisible", "isVisible$annotations", "(Landroidx/compose/ui/semantics/SemanticsNode;)V", "accessibilityEquals", "Landroidx/compose/ui/semantics/AccessibilityAction;", "other", "", "enabled", "excludeLineAndPageGranularities", "findById", "Landroidx/compose/ui/platform/ScrollObservationScope;", "", "id", "", "findClosestParentNode", "Landroidx/compose/ui/node/LayoutNode;", "selector", "Lkotlin/Function1;", "getAllUncoveredSemanticsNodesToMap", "", "Landroidx/compose/ui/platform/SemanticsNodeWithAdjustedBounds;", "Landroidx/compose/ui/semantics/SemanticsOwner;", "hasPaneTitle", "overlaps", "Landroidx/compose/ui/platform/OpenEndRange;", "it", "propertiesDeleted", "oldNode", "Landroidx/compose/ui/platform/AndroidComposeViewAccessibilityDelegateCompat$SemanticsNodeCopy;", "rangeUntil", "that", "semanticsIdToView", "Landroid/view/View;", "Landroidx/compose/ui/platform/AndroidViewsHandler;", "toLegacyClassName", "Landroidx/compose/ui/semantics/Role;", "toLegacyClassName-V4PA4sw", "(I)Ljava/lang/String;", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class AndroidComposeViewAccessibilityDelegateCompat_androidKt {
    private static /* synthetic */ void isVisible$annotations(SemanticsNode semanticsNode) {
    }

    public static final OpenEndRange<Float> rangeUntil(float $this$rangeUntil, float that) {
        return new OpenEndFloatRange($this$rangeUntil, that);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean overlaps(OpenEndRange<Float> openEndRange, OpenEndRange<Float> openEndRange2) {
        return (openEndRange.isEmpty() || openEndRange2.isEmpty() || Math.max(openEndRange.getStart().floatValue(), openEndRange2.getStart().floatValue()) >= Math.min(openEndRange.getEndExclusive().floatValue(), openEndRange2.getEndExclusive().floatValue())) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final LayoutNode findClosestParentNode(LayoutNode $this$findClosestParentNode, Function1<? super LayoutNode, Boolean> function1) {
        for (LayoutNode currentParent = $this$findClosestParentNode.getParent$ui_release(); currentParent != null; currentParent = currentParent.getParent$ui_release()) {
            if (function1.invoke(currentParent).booleanValue()) {
                return currentParent;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean enabled(SemanticsNode $this$enabled) {
        return SemanticsConfigurationKt.getOrNull($this$enabled.getConfig(), SemanticsProperties.INSTANCE.getDisabled()) == null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean isVisible(SemanticsNode $this$isVisible) {
        return ($this$isVisible.isTransparent$ui_release() || $this$isVisible.getUnmergedConfig().contains(SemanticsProperties.INSTANCE.getInvisibleToUser())) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean propertiesDeleted(SemanticsNode $this$propertiesDeleted, AndroidComposeViewAccessibilityDelegateCompat.SemanticsNodeCopy oldNode) {
        Iterator<Map.Entry<? extends SemanticsPropertyKey<?>, ? extends Object>> it = oldNode.getUnmergedConfig().iterator();
        while (it.hasNext()) {
            Map.Entry entry = it.next();
            if (!$this$propertiesDeleted.getConfig().contains(entry.getKey())) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean hasPaneTitle(SemanticsNode $this$hasPaneTitle) {
        return $this$hasPaneTitle.getConfig().contains(SemanticsProperties.INSTANCE.getPaneTitle());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean isPassword(SemanticsNode $this$isPassword) {
        return $this$isPassword.getConfig().contains(SemanticsProperties.INSTANCE.getPassword());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean isTextField(SemanticsNode $this$isTextField) {
        return $this$isTextField.getUnmergedConfig().contains(SemanticsActions.INSTANCE.getSetText());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean isRtl(SemanticsNode $this$isRtl) {
        return $this$isRtl.getLayoutInfo().getLayoutDirection() == LayoutDirection.Rtl;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Boolean isTraversalGroup(SemanticsNode $this$isTraversalGroup) {
        return (Boolean) SemanticsConfigurationKt.getOrNull($this$isTraversalGroup.getConfig(), SemanticsProperties.INSTANCE.getIsTraversalGroup());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float getGetTraversalIndex(SemanticsNode $this$getTraversalIndex) {
        if ($this$getTraversalIndex.getConfig().contains(SemanticsProperties.INSTANCE.getTraversalIndex())) {
            return ((Number) $this$getTraversalIndex.getConfig().get(SemanticsProperties.INSTANCE.getTraversalIndex())).floatValue();
        }
        return 0.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String getInfoContentDescriptionOrNull(SemanticsNode $this$infoContentDescriptionOrNull) {
        List list = (List) SemanticsConfigurationKt.getOrNull($this$infoContentDescriptionOrNull.getUnmergedConfig(), SemanticsProperties.INSTANCE.getContentDescription());
        if (list != null) {
            return (String) CollectionsKt.firstOrNull(list);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean excludeLineAndPageGranularities(SemanticsNode $this$excludeLineAndPageGranularities) {
        if (isTextField($this$excludeLineAndPageGranularities) && !Intrinsics.areEqual(SemanticsConfigurationKt.getOrNull($this$excludeLineAndPageGranularities.getUnmergedConfig(), SemanticsProperties.INSTANCE.getFocused()), (Object) true)) {
            return true;
        }
        LayoutNode ancestor = findClosestParentNode($this$excludeLineAndPageGranularities.getLayoutNode(), new Function1<LayoutNode, Boolean>() { // from class: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat_androidKt$excludeLineAndPageGranularities$ancestor$1
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(LayoutNode it) {
                Intrinsics.checkNotNullParameter(it, "it");
                SemanticsConfiguration ancestorSemanticsConfiguration = it.getCollapsedSemantics$ui_release();
                return Boolean.valueOf((ancestorSemanticsConfiguration != null && ancestorSemanticsConfiguration.getIsMergingSemanticsOfDescendants()) && ancestorSemanticsConfiguration.contains(SemanticsActions.INSTANCE.getSetText()));
            }
        });
        if (ancestor != null) {
            SemanticsConfiguration collapsedSemantics$ui_release = ancestor.getCollapsedSemantics$ui_release();
            if (!(collapsedSemantics$ui_release != null ? Intrinsics.areEqual(SemanticsConfigurationKt.getOrNull(collapsedSemantics$ui_release, SemanticsProperties.INSTANCE.getFocused()), (Object) true) : false)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean accessibilityEquals(AccessibilityAction<?> accessibilityAction, Object other) {
        if (accessibilityAction == other) {
            return true;
        }
        if (!(other instanceof AccessibilityAction) || !Intrinsics.areEqual(accessibilityAction.getLabel(), ((AccessibilityAction) other).getLabel())) {
            return false;
        }
        if (accessibilityAction.getAction() != null || ((AccessibilityAction) other).getAction() == null) {
            return accessibilityAction.getAction() == null || ((AccessibilityAction) other).getAction() != null;
        }
        return false;
    }

    public static final Map<Integer, SemanticsNodeWithAdjustedBounds> getAllUncoveredSemanticsNodesToMap(SemanticsOwner $this$getAllUncoveredSemanticsNodesToMap) {
        Intrinsics.checkNotNullParameter($this$getAllUncoveredSemanticsNodesToMap, "<this>");
        SemanticsNode root = $this$getAllUncoveredSemanticsNodesToMap.getUnmergedRootSemanticsNode();
        Map nodes = new LinkedHashMap();
        if (!root.getLayoutNode().isPlaced() || !root.getLayoutNode().isAttached()) {
            return nodes;
        }
        Region unaccountedSpace = new Region();
        Rect $this$getAllUncoveredSemanticsNodesToMap_u24lambda_u241_u24lambda_u240 = root.getBoundsInRoot();
        unaccountedSpace.set(new android.graphics.Rect(MathKt.roundToInt($this$getAllUncoveredSemanticsNodesToMap_u24lambda_u241_u24lambda_u240.getLeft()), MathKt.roundToInt($this$getAllUncoveredSemanticsNodesToMap_u24lambda_u241_u24lambda_u240.getTop()), MathKt.roundToInt($this$getAllUncoveredSemanticsNodesToMap_u24lambda_u241_u24lambda_u240.getRight()), MathKt.roundToInt($this$getAllUncoveredSemanticsNodesToMap_u24lambda_u241_u24lambda_u240.getBottom())));
        getAllUncoveredSemanticsNodesToMap$findAllSemanticNodesRecursive(unaccountedSpace, root, nodes, root);
        return nodes;
    }

    private static final void getAllUncoveredSemanticsNodesToMap$findAllSemanticNodesRecursive(Region unaccountedSpace, SemanticsNode root, Map<Integer, SemanticsNodeWithAdjustedBounds> map, SemanticsNode currentNode) {
        int virtualViewId;
        Rect boundsForFakeNode;
        LayoutInfo layoutInfo;
        boolean z = false;
        boolean notAttachedOrPlaced = (currentNode.getLayoutNode().isPlaced() && currentNode.getLayoutNode().isAttached()) ? false : true;
        if (!unaccountedSpace.isEmpty() || currentNode.getId() == root.getId()) {
            if (notAttachedOrPlaced && !currentNode.getIsFake()) {
                return;
            }
            Rect touchBoundsInRoot = currentNode.getTouchBoundsInRoot();
            android.graphics.Rect boundsInRoot = new android.graphics.Rect(MathKt.roundToInt(touchBoundsInRoot.getLeft()), MathKt.roundToInt(touchBoundsInRoot.getTop()), MathKt.roundToInt(touchBoundsInRoot.getRight()), MathKt.roundToInt(touchBoundsInRoot.getBottom()));
            Region region = new Region();
            region.set(boundsInRoot);
            if (currentNode.getId() == root.getId()) {
                virtualViewId = -1;
            } else {
                virtualViewId = currentNode.getId();
            }
            if (region.op(unaccountedSpace, region, Region.Op.INTERSECT)) {
                Integer valueOf = Integer.valueOf(virtualViewId);
                android.graphics.Rect bounds = region.getBounds();
                Intrinsics.checkNotNullExpressionValue(bounds, "region.bounds");
                map.put(valueOf, new SemanticsNodeWithAdjustedBounds(currentNode, bounds));
                List children = currentNode.getReplacedChildren$ui_release();
                for (int i = children.size() - 1; -1 < i; i--) {
                    getAllUncoveredSemanticsNodesToMap$findAllSemanticNodesRecursive(unaccountedSpace, root, map, children.get(i));
                }
                unaccountedSpace.op(boundsInRoot, unaccountedSpace, Region.Op.REVERSE_DIFFERENCE);
                return;
            }
            if (!currentNode.getIsFake()) {
                if (virtualViewId == -1) {
                    Integer valueOf2 = Integer.valueOf(virtualViewId);
                    android.graphics.Rect bounds2 = region.getBounds();
                    Intrinsics.checkNotNullExpressionValue(bounds2, "region.bounds");
                    map.put(valueOf2, new SemanticsNodeWithAdjustedBounds(currentNode, bounds2));
                    return;
                }
                return;
            }
            SemanticsNode parentNode = currentNode.getParent();
            if (parentNode != null && (layoutInfo = parentNode.getLayoutInfo()) != null && layoutInfo.isPlaced()) {
                z = true;
            }
            if (z) {
                boundsForFakeNode = parentNode.getBoundsInRoot();
            } else {
                boundsForFakeNode = new Rect(0.0f, 0.0f, 10.0f, 10.0f);
            }
            map.put(Integer.valueOf(virtualViewId), new SemanticsNodeWithAdjustedBounds(currentNode, new android.graphics.Rect(MathKt.roundToInt(boundsForFakeNode.getLeft()), MathKt.roundToInt(boundsForFakeNode.getTop()), MathKt.roundToInt(boundsForFakeNode.getRight()), MathKt.roundToInt(boundsForFakeNode.getBottom()))));
        }
    }

    public static final ScrollObservationScope findById(List<ScrollObservationScope> list, int id) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        int size = list.size();
        for (int index = 0; index < size; index++) {
            if (list.get(index).getSemanticsNodeId() == id) {
                return list.get(index);
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: toLegacyClassName-V4PA4sw, reason: not valid java name */
    public static final String m4489toLegacyClassNameV4PA4sw(int $this$toLegacyClassName_u2dV4PA4sw) {
        if (Role.m4564equalsimpl0($this$toLegacyClassName_u2dV4PA4sw, Role.INSTANCE.m4568getButtono7Vup1c())) {
            return "android.widget.Button";
        }
        if (Role.m4564equalsimpl0($this$toLegacyClassName_u2dV4PA4sw, Role.INSTANCE.m4569getCheckboxo7Vup1c())) {
            return "android.widget.CheckBox";
        }
        if (Role.m4564equalsimpl0($this$toLegacyClassName_u2dV4PA4sw, Role.INSTANCE.m4572getRadioButtono7Vup1c())) {
            return "android.widget.RadioButton";
        }
        if (Role.m4564equalsimpl0($this$toLegacyClassName_u2dV4PA4sw, Role.INSTANCE.m4571getImageo7Vup1c())) {
            return "android.widget.ImageView";
        }
        if (Role.m4564equalsimpl0($this$toLegacyClassName_u2dV4PA4sw, Role.INSTANCE.m4570getDropdownListo7Vup1c())) {
            return "android.widget.Spinner";
        }
        return null;
    }

    public static final View semanticsIdToView(AndroidViewsHandler $this$semanticsIdToView, int id) {
        Object element$iv;
        Intrinsics.checkNotNullParameter($this$semanticsIdToView, "<this>");
        Iterable entrySet = $this$semanticsIdToView.getLayoutNodeToHolder().entrySet();
        Intrinsics.checkNotNullExpressionValue(entrySet, "layoutNodeToHolder.entries");
        Iterable $this$firstOrNull$iv = entrySet;
        Iterator it = $this$firstOrNull$iv.iterator();
        while (true) {
            if (it.hasNext()) {
                element$iv = it.next();
                Map.Entry it2 = (Map.Entry) element$iv;
                if (((LayoutNode) it2.getKey()).getSemanticsId() == id) {
                    break;
                }
            } else {
                element$iv = null;
                break;
            }
        }
        Map.Entry entry = (Map.Entry) element$iv;
        return entry != null ? (AndroidViewHolder) entry.getValue() : null;
    }
}
