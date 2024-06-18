package androidx.compose.ui.tooling.animation;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationVector;
import androidx.compose.animation.core.DecayAnimation;
import androidx.compose.animation.core.InfiniteTransition;
import androidx.compose.animation.core.TargetBasedAnimation;
import androidx.compose.animation.core.Transition;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.State;
import androidx.compose.ui.tooling.PreviewUtilsKt;
import androidx.compose.ui.tooling.animation.AnimationSearch;
import androidx.compose.ui.tooling.data.CallGroup;
import androidx.compose.ui.tooling.data.Group;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KClasses;

/* compiled from: AnimationSearch.kt */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0000\u0018\u00002\u00020\u0001:\f!\"#$%&'()*+,B!\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003¢\u0006\u0002\u0010\u0007J\u000e\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018H\u0002J\u0014\u0010\u001a\u001a\u00020\u00062\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001c0\u0018J\u000e\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001e0\u0011H\u0002J\u0016\u0010\u0014\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u00120\u0011H\u0002J\u0006\u0010\u001f\u001a\u00020\u0006J\u0016\u0010 \u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u00120\u0018H\u0002R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\f\u001a\u00020\r8F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0010\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u00120\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0013\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u00120\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0014\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u00120\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006-"}, d2 = {"Landroidx/compose/ui/tooling/animation/AnimationSearch;", "", "clock", "Lkotlin/Function0;", "Landroidx/compose/ui/tooling/animation/PreviewAnimationClock;", "onSeek", "", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "animatedContentSearch", "Landroidx/compose/ui/tooling/animation/AnimationSearch$AnimatedContentSearch;", "animatedVisibilitySearch", "Landroidx/compose/ui/tooling/animation/AnimationSearch$AnimatedVisibilitySearch;", "hasAnimations", "", "getHasAnimations", "()Z", "setToSearch", "", "Landroidx/compose/ui/tooling/animation/AnimationSearch$Search;", "setToTrack", "supportedSearch", "transitionSearch", "Landroidx/compose/ui/tooling/animation/AnimationSearch$TransitionSearch;", "animateXAsStateSearch", "", "Landroidx/compose/ui/tooling/animation/AnimationSearch$AnimateXAsStateSearch;", "findAll", "slotTrees", "Landroidx/compose/ui/tooling/data/Group;", "infiniteTransitionSearch", "Landroidx/compose/ui/tooling/animation/AnimationSearch$InfiniteTransitionSearch;", "trackAll", "unsupportedSearch", "AnimateContentSizeSearch", "AnimateXAsStateSearch", "AnimateXAsStateSearchInfo", "AnimatedContentSearch", "AnimatedVisibilitySearch", "DecaySearch", "InfiniteTransitionSearch", "InfiniteTransitionSearchInfo", "RememberSearch", "Search", "TargetBasedSearch", "TransitionSearch", "ui-tooling_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class AnimationSearch {
    private final AnimatedContentSearch animatedContentSearch;
    private final AnimatedVisibilitySearch animatedVisibilitySearch;
    private final Function0<PreviewAnimationClock> clock;
    private final Function0<Unit> onSeek;
    private final Set<Search<? extends Object>> setToSearch;
    private final Set<Search<? extends Object>> setToTrack;
    private final Set<Search<? extends Object>> supportedSearch;
    private final TransitionSearch transitionSearch;

    /* JADX WARN: Multi-variable type inference failed */
    public AnimationSearch(Function0<? extends PreviewAnimationClock> clock, Function0<Unit> onSeek) {
        Intrinsics.checkNotNullParameter(clock, "clock");
        Intrinsics.checkNotNullParameter(onSeek, "onSeek");
        this.clock = clock;
        this.onSeek = onSeek;
        this.transitionSearch = new TransitionSearch(new Function1<Transition<?>, Unit>() { // from class: androidx.compose.ui.tooling.animation.AnimationSearch$transitionSearch$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Transition<?> transition) {
                invoke2(transition);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Transition<?> it) {
                Function0 function0;
                Intrinsics.checkNotNullParameter(it, "it");
                function0 = AnimationSearch.this.clock;
                ((PreviewAnimationClock) function0.invoke()).trackTransition(it);
            }
        });
        this.animatedContentSearch = new AnimatedContentSearch(new Function1<Transition<?>, Unit>() { // from class: androidx.compose.ui.tooling.animation.AnimationSearch$animatedContentSearch$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Transition<?> transition) {
                invoke2(transition);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Transition<?> it) {
                Function0 function0;
                Intrinsics.checkNotNullParameter(it, "it");
                function0 = AnimationSearch.this.clock;
                ((PreviewAnimationClock) function0.invoke()).trackAnimatedContent(it);
            }
        });
        this.animatedVisibilitySearch = new AnimatedVisibilitySearch(new Function1<Transition<?>, Unit>() { // from class: androidx.compose.ui.tooling.animation.AnimationSearch$animatedVisibilitySearch$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Transition<?> transition) {
                invoke2(transition);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Transition<?> it) {
                Function0 function0;
                Function0<Unit> function02;
                Intrinsics.checkNotNullParameter(it, "it");
                function0 = AnimationSearch.this.clock;
                PreviewAnimationClock previewAnimationClock = (PreviewAnimationClock) function0.invoke();
                function02 = AnimationSearch.this.onSeek;
                previewAnimationClock.trackAnimatedVisibility(it, function02);
            }
        });
        this.supportedSearch = supportedSearch();
        this.setToTrack = SetsKt.plus((Set) this.supportedSearch, (Iterable) unsupportedSearch());
        this.setToSearch = SetsKt.plus((Set) this.setToTrack, (Iterable) SetsKt.setOf(this.animatedContentSearch));
    }

    private final Collection<AnimateXAsStateSearch> animateXAsStateSearch() {
        if (AnimateXAsStateComposeAnimation.INSTANCE.getApiAvailable()) {
            return SetsKt.setOf(new AnimateXAsStateSearch(new Function1<AnimateXAsStateSearchInfo<?, ?>, Unit>() { // from class: androidx.compose.ui.tooling.animation.AnimationSearch$animateXAsStateSearch$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(AnimationSearch.AnimateXAsStateSearchInfo<?, ?> animateXAsStateSearchInfo) {
                    invoke2(animateXAsStateSearchInfo);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(AnimationSearch.AnimateXAsStateSearchInfo<?, ?> it) {
                    Function0 function0;
                    Intrinsics.checkNotNullParameter(it, "it");
                    function0 = AnimationSearch.this.clock;
                    ((PreviewAnimationClock) function0.invoke()).trackAnimateXAsState(it);
                }
            }));
        }
        return CollectionsKt.emptyList();
    }

    private final Set<InfiniteTransitionSearch> infiniteTransitionSearch() {
        if (InfiniteTransitionComposeAnimation.INSTANCE.getApiAvailable()) {
            return SetsKt.setOf(new InfiniteTransitionSearch(new Function1<InfiniteTransitionSearchInfo, Unit>() { // from class: androidx.compose.ui.tooling.animation.AnimationSearch$infiniteTransitionSearch$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(AnimationSearch.InfiniteTransitionSearchInfo infiniteTransitionSearchInfo) {
                    invoke2(infiniteTransitionSearchInfo);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(AnimationSearch.InfiniteTransitionSearchInfo it) {
                    Function0 function0;
                    Intrinsics.checkNotNullParameter(it, "it");
                    function0 = AnimationSearch.this.clock;
                    ((PreviewAnimationClock) function0.invoke()).trackInfiniteTransition(it);
                }
            }));
        }
        return SetsKt.emptySet();
    }

    private final Set<Search<? extends Object>> supportedSearch() {
        return SetsKt.plus(SetsKt.plus(SetsKt.plus(SetsKt.setOf((Object[]) new Search[]{this.transitionSearch, this.animatedVisibilitySearch}), (Iterable) animateXAsStateSearch()), (Iterable) infiniteTransitionSearch()), (Iterable) (AnimatedContentComposeAnimation.INSTANCE.getApiAvailable() ? SetsKt.setOf(this.animatedContentSearch) : SetsKt.emptySet()));
    }

    private final Collection<Search<? extends Object>> unsupportedSearch() {
        return UnsupportedComposeAnimation.INSTANCE.getApiAvailable() ? SetsKt.setOf((Object[]) new Search[]{new AnimateContentSizeSearch(new Function1<Object, Unit>() { // from class: androidx.compose.ui.tooling.animation.AnimationSearch$unsupportedSearch$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Object p1) {
                invoke2(p1);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Object it) {
                Function0 function0;
                Intrinsics.checkNotNullParameter(it, "it");
                function0 = AnimationSearch.this.clock;
                ((PreviewAnimationClock) function0.invoke()).trackAnimateContentSize(it);
            }
        }), new TargetBasedSearch(new Function1<TargetBasedAnimation<?, ?>, Unit>() { // from class: androidx.compose.ui.tooling.animation.AnimationSearch$unsupportedSearch$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(TargetBasedAnimation<?, ?> targetBasedAnimation) {
                invoke2(targetBasedAnimation);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(TargetBasedAnimation<?, ?> it) {
                Function0 function0;
                Intrinsics.checkNotNullParameter(it, "it");
                function0 = AnimationSearch.this.clock;
                ((PreviewAnimationClock) function0.invoke()).trackTargetBasedAnimations(it);
            }
        }), new DecaySearch(new Function1<DecayAnimation<?, ?>, Unit>() { // from class: androidx.compose.ui.tooling.animation.AnimationSearch$unsupportedSearch$3
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(DecayAnimation<?, ?> decayAnimation) {
                invoke2(decayAnimation);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(DecayAnimation<?, ?> it) {
                Function0 function0;
                Intrinsics.checkNotNullParameter(it, "it");
                function0 = AnimationSearch.this.clock;
                ((PreviewAnimationClock) function0.invoke()).trackDecayAnimations(it);
            }
        })}) : CollectionsKt.emptyList();
    }

    public final boolean getHasAnimations() {
        Iterable $this$any$iv = this.supportedSearch;
        if (($this$any$iv instanceof Collection) && ((Collection) $this$any$iv).isEmpty()) {
            return false;
        }
        for (Object element$iv : $this$any$iv) {
            Search it = (Search) element$iv;
            if (it.hasAnimations()) {
                return true;
            }
        }
        return false;
    }

    public final void findAll(Collection<? extends Group> slotTrees) {
        Intrinsics.checkNotNullParameter(slotTrees, "slotTrees");
        Collection<? extends Group> $this$forEach$iv = slotTrees;
        for (Object element$iv : $this$forEach$iv) {
            Group tree = (Group) element$iv;
            List groupsWithLocation = PreviewUtilsKt.findAll(tree, new Function1<Group, Boolean>() { // from class: androidx.compose.ui.tooling.animation.AnimationSearch$findAll$1$groupsWithLocation$1
                @Override // kotlin.jvm.functions.Function1
                public final Boolean invoke(Group it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return Boolean.valueOf(it.getLocation() != null);
                }
            });
            Iterable $this$forEach$iv2 = this.setToSearch;
            for (Object element$iv2 : $this$forEach$iv2) {
                Search it = (Search) element$iv2;
                it.addAnimations(groupsWithLocation);
            }
            this.transitionSearch.getAnimations().removeAll(this.animatedVisibilitySearch.getAnimations());
            this.transitionSearch.getAnimations().removeAll(this.animatedContentSearch.getAnimations());
        }
    }

    public final void trackAll() {
        if (getHasAnimations()) {
            Iterable $this$forEach$iv = this.setToTrack;
            for (Object element$iv : $this$forEach$iv) {
                Search it = (Search) element$iv;
                it.track();
            }
        }
    }

    /* compiled from: AnimationSearch.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\b\u0004\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0017\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0002B\u0019\u0012\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0002\u0010\u0006J\u0016\u0010\u000b\u001a\u00020\u00052\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0016J\u0006\u0010\u000f\u001a\u00020\u0010J\u0006\u0010\u0011\u001a\u00020\u0005R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Landroidx/compose/ui/tooling/animation/AnimationSearch$Search;", "T", "", "trackAnimation", "Lkotlin/Function1;", "", "(Lkotlin/jvm/functions/Function1;)V", "animations", "", "getAnimations", "()Ljava/util/Set;", "addAnimations", "groupsWithLocation", "", "Landroidx/compose/ui/tooling/data/Group;", "hasAnimations", "", "track", "ui-tooling_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes.dex */
    public static class Search<T> {
        public static final int $stable = 8;
        private final Set<T> animations;
        private final Function1<T, Unit> trackAnimation;

        /* JADX WARN: Multi-variable type inference failed */
        public Search(Function1<? super T, Unit> trackAnimation) {
            Intrinsics.checkNotNullParameter(trackAnimation, "trackAnimation");
            this.trackAnimation = trackAnimation;
            this.animations = new LinkedHashSet();
        }

        public final Set<T> getAnimations() {
            return this.animations;
        }

        public void addAnimations(Collection<? extends Group> groupsWithLocation) {
            Intrinsics.checkNotNullParameter(groupsWithLocation, "groupsWithLocation");
        }

        public final boolean hasAnimations() {
            return !this.animations.isEmpty();
        }

        public final void track() {
            Iterable $this$forEach$iv = CollectionsKt.reversed(this.animations);
            Function1 action$iv = this.trackAnimation;
            Iterator<T> it = $this$forEach$iv.iterator();
            while (it.hasNext()) {
                action$iv.invoke(it.next());
            }
        }
    }

    /* compiled from: AnimationSearch.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\b\u0017\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B'\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\u0010\tJ\u0016\u0010\n\u001a\u00020\b2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0016J0\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\u00010\u000f\"\b\b\u0001\u0010\u0001*\u00020\u0002*\b\u0012\u0004\u0012\u00020\r0\f2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00010\u0005H\u0002R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Landroidx/compose/ui/tooling/animation/AnimationSearch$RememberSearch;", "T", "", "Landroidx/compose/ui/tooling/animation/AnimationSearch$Search;", "clazz", "Lkotlin/reflect/KClass;", "trackAnimation", "Lkotlin/Function1;", "", "(Lkotlin/reflect/KClass;Lkotlin/jvm/functions/Function1;)V", "addAnimations", "groupsWithLocation", "", "Landroidx/compose/ui/tooling/data/Group;", "findRememberCallWithType", "", "ui-tooling_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes.dex */
    public static class RememberSearch<T> extends Search<T> {
        public static final int $stable = 8;
        private final KClass<T> clazz;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public RememberSearch(KClass<T> clazz, Function1<? super T, Unit> trackAnimation) {
            super(trackAnimation);
            Intrinsics.checkNotNullParameter(clazz, "clazz");
            Intrinsics.checkNotNullParameter(trackAnimation, "trackAnimation");
            this.clazz = clazz;
        }

        @Override // androidx.compose.ui.tooling.animation.AnimationSearch.Search
        public void addAnimations(Collection<? extends Group> groupsWithLocation) {
            Intrinsics.checkNotNullParameter(groupsWithLocation, "groupsWithLocation");
            getAnimations().addAll(CollectionsKt.toSet(findRememberCallWithType(groupsWithLocation, this.clazz)));
        }

        private final <T> List<T> findRememberCallWithType(Collection<? extends Group> collection, KClass<T> kClass) {
            Iterable $this$mapNotNull$iv;
            Object obj;
            Class<?> cls;
            Collection<? extends Group> $this$mapNotNull$iv2 = collection;
            Collection destination$iv$iv = new ArrayList();
            for (Object element$iv$iv$iv : $this$mapNotNull$iv2) {
                Group it = (Group) element$iv$iv$iv;
                Iterable $this$firstOrNull$iv = it.getData();
                Iterator<T> it2 = $this$firstOrNull$iv.iterator();
                while (true) {
                    KClass kClass2 = null;
                    if (!it2.hasNext()) {
                        $this$mapNotNull$iv = $this$mapNotNull$iv2;
                        obj = null;
                        break;
                    }
                    Object element$iv = it2.next();
                    if (element$iv != null && (cls = element$iv.getClass()) != null) {
                        kClass2 = JvmClassMappingKt.getKotlinClass(cls);
                    }
                    $this$mapNotNull$iv = $this$mapNotNull$iv2;
                    if (Intrinsics.areEqual(kClass2, kClass)) {
                        obj = element$iv;
                        break;
                    }
                    $this$mapNotNull$iv2 = $this$mapNotNull$iv;
                }
                Object it$iv$iv = KClasses.safeCast(kClass, obj);
                if (it$iv$iv != null) {
                    destination$iv$iv.add(it$iv$iv);
                }
                $this$mapNotNull$iv2 = $this$mapNotNull$iv;
            }
            return (List) destination$iv$iv;
        }
    }

    /* compiled from: AnimationSearch.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u0010\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00020\u0001B!\u0012\u001a\u0010\u0003\u001a\u0016\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0002\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"Landroidx/compose/ui/tooling/animation/AnimationSearch$TargetBasedSearch;", "Landroidx/compose/ui/tooling/animation/AnimationSearch$RememberSearch;", "Landroidx/compose/animation/core/TargetBasedAnimation;", "trackAnimation", "Lkotlin/Function1;", "", "(Lkotlin/jvm/functions/Function1;)V", "ui-tooling_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes.dex */
    public static final class TargetBasedSearch extends RememberSearch<TargetBasedAnimation<?, ?>> {
        public static final int $stable = 0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public TargetBasedSearch(Function1<? super TargetBasedAnimation<?, ?>, Unit> trackAnimation) {
            super(Reflection.getOrCreateKotlinClass(TargetBasedAnimation.class), trackAnimation);
            Intrinsics.checkNotNullParameter(trackAnimation, "trackAnimation");
        }
    }

    /* compiled from: AnimationSearch.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u0010\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00020\u0001B!\u0012\u001a\u0010\u0003\u001a\u0016\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0002\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"Landroidx/compose/ui/tooling/animation/AnimationSearch$DecaySearch;", "Landroidx/compose/ui/tooling/animation/AnimationSearch$RememberSearch;", "Landroidx/compose/animation/core/DecayAnimation;", "trackAnimation", "Lkotlin/Function1;", "", "(Lkotlin/jvm/functions/Function1;)V", "ui-tooling_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes.dex */
    public static final class DecaySearch extends RememberSearch<DecayAnimation<?, ?>> {
        public static final int $stable = 0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public DecaySearch(Function1<? super DecayAnimation<?, ?>, Unit> trackAnimation) {
            super(Reflection.getOrCreateKotlinClass(DecayAnimation.class), trackAnimation);
            Intrinsics.checkNotNullParameter(trackAnimation, "trackAnimation");
        }
    }

    /* compiled from: AnimationSearch.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J#\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Landroidx/compose/ui/tooling/animation/AnimationSearch$InfiniteTransitionSearchInfo;", "", "infiniteTransition", "Landroidx/compose/animation/core/InfiniteTransition;", "toolingState", "Landroidx/compose/ui/tooling/animation/ToolingState;", "", "(Landroidx/compose/animation/core/InfiniteTransition;Landroidx/compose/ui/tooling/animation/ToolingState;)V", "getInfiniteTransition", "()Landroidx/compose/animation/core/InfiniteTransition;", "getToolingState", "()Landroidx/compose/ui/tooling/animation/ToolingState;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "ui-tooling_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes.dex */
    public static final /* data */ class InfiniteTransitionSearchInfo {
        public static final int $stable = InfiniteTransition.$stable;
        private final InfiniteTransition infiniteTransition;
        private final ToolingState<Long> toolingState;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ InfiniteTransitionSearchInfo copy$default(InfiniteTransitionSearchInfo infiniteTransitionSearchInfo, InfiniteTransition infiniteTransition, ToolingState toolingState, int i, Object obj) {
            if ((i & 1) != 0) {
                infiniteTransition = infiniteTransitionSearchInfo.infiniteTransition;
            }
            if ((i & 2) != 0) {
                toolingState = infiniteTransitionSearchInfo.toolingState;
            }
            return infiniteTransitionSearchInfo.copy(infiniteTransition, toolingState);
        }

        /* renamed from: component1, reason: from getter */
        public final InfiniteTransition getInfiniteTransition() {
            return this.infiniteTransition;
        }

        public final ToolingState<Long> component2() {
            return this.toolingState;
        }

        public final InfiniteTransitionSearchInfo copy(InfiniteTransition infiniteTransition, ToolingState<Long> toolingState) {
            Intrinsics.checkNotNullParameter(infiniteTransition, "infiniteTransition");
            Intrinsics.checkNotNullParameter(toolingState, "toolingState");
            return new InfiniteTransitionSearchInfo(infiniteTransition, toolingState);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof InfiniteTransitionSearchInfo)) {
                return false;
            }
            InfiniteTransitionSearchInfo infiniteTransitionSearchInfo = (InfiniteTransitionSearchInfo) other;
            return Intrinsics.areEqual(this.infiniteTransition, infiniteTransitionSearchInfo.infiniteTransition) && Intrinsics.areEqual(this.toolingState, infiniteTransitionSearchInfo.toolingState);
        }

        public int hashCode() {
            return (this.infiniteTransition.hashCode() * 31) + this.toolingState.hashCode();
        }

        public String toString() {
            return "InfiniteTransitionSearchInfo(infiniteTransition=" + this.infiniteTransition + ", toolingState=" + this.toolingState + ')';
        }

        public InfiniteTransitionSearchInfo(InfiniteTransition infiniteTransition, ToolingState<Long> toolingState) {
            Intrinsics.checkNotNullParameter(infiniteTransition, "infiniteTransition");
            Intrinsics.checkNotNullParameter(toolingState, "toolingState");
            this.infiniteTransition = infiniteTransition;
            this.toolingState = toolingState;
        }

        public final InfiniteTransition getInfiniteTransition() {
            return this.infiniteTransition;
        }

        public final ToolingState<Long> getToolingState() {
            return this.toolingState;
        }
    }

    /* compiled from: AnimationSearch.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0019\u0012\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0002\u0010\u0006J\u0016\u0010\u0007\u001a\u00020\u00052\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0016J\u001c\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\f2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0002¨\u0006\r"}, d2 = {"Landroidx/compose/ui/tooling/animation/AnimationSearch$InfiniteTransitionSearch;", "Landroidx/compose/ui/tooling/animation/AnimationSearch$Search;", "Landroidx/compose/ui/tooling/animation/AnimationSearch$InfiniteTransitionSearchInfo;", "trackAnimation", "Lkotlin/Function1;", "", "(Lkotlin/jvm/functions/Function1;)V", "addAnimations", "groupsWithLocation", "", "Landroidx/compose/ui/tooling/data/Group;", "findAnimations", "", "ui-tooling_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes.dex */
    public static final class InfiniteTransitionSearch extends Search<InfiniteTransitionSearchInfo> {
        public static final int $stable = 0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public InfiniteTransitionSearch(Function1<? super InfiniteTransitionSearchInfo, Unit> trackAnimation) {
            super(trackAnimation);
            Intrinsics.checkNotNullParameter(trackAnimation, "trackAnimation");
        }

        @Override // androidx.compose.ui.tooling.animation.AnimationSearch.Search
        public void addAnimations(Collection<? extends Group> groupsWithLocation) {
            Intrinsics.checkNotNullParameter(groupsWithLocation, "groupsWithLocation");
            getAnimations().addAll(findAnimations(groupsWithLocation));
        }

        private final List<InfiniteTransitionSearchInfo> findAnimations(Collection<? extends Group> groupsWithLocation) {
            InfiniteTransitionSearchInfo infiniteTransitionSearchInfo;
            Object obj;
            Object obj2;
            Collection<? extends Group> $this$filter$iv = groupsWithLocation;
            Collection destination$iv$iv = new ArrayList();
            for (Object element$iv$iv : $this$filter$iv) {
                Group group = (Group) element$iv$iv;
                if (Intrinsics.areEqual(group.getName(), "rememberInfiniteTransition")) {
                    destination$iv$iv.add(element$iv$iv);
                }
            }
            Iterable $this$filterIsInstance$iv = (List) destination$iv$iv;
            Collection destination$iv$iv2 = new ArrayList();
            for (Object element$iv$iv2 : $this$filterIsInstance$iv) {
                if (element$iv$iv2 instanceof CallGroup) {
                    destination$iv$iv2.add(element$iv$iv2);
                }
            }
            Object it$iv$iv = (List) destination$iv$iv2;
            Iterable $this$mapNotNull$iv = (Iterable) it$iv$iv;
            int $i$f$mapNotNull = 0;
            Collection destination$iv$iv3 = new ArrayList();
            Iterable $this$mapNotNullTo$iv$iv = $this$mapNotNull$iv;
            for (Object element$iv$iv$iv : $this$mapNotNullTo$iv$iv) {
                Group it = (CallGroup) element$iv$iv$iv;
                Group $this$findData_u24default$iv = it;
                Object groups = it$iv$iv;
                Collection<Object> data = $this$findData_u24default$iv.getData();
                Iterable $this$flatMap$iv$iv = $this$findData_u24default$iv.getChildren();
                Iterable $this$mapNotNull$iv2 = $this$mapNotNull$iv;
                Collection destination$iv$iv$iv = new ArrayList();
                for (Object element$iv$iv$iv2 : $this$flatMap$iv$iv) {
                    CollectionsKt.addAll(destination$iv$iv$iv, ((Group) element$iv$iv$iv2).getData());
                    $i$f$mapNotNull = $i$f$mapNotNull;
                }
                int $i$f$mapNotNull2 = $i$f$mapNotNull;
                List dataToSearch$iv = CollectionsKt.plus((Collection) data, destination$iv$iv$iv);
                List $this$firstOrNull$iv$iv = dataToSearch$iv;
                Iterator it2 = $this$firstOrNull$iv$iv.iterator();
                while (true) {
                    infiniteTransitionSearchInfo = null;
                    if (!it2.hasNext()) {
                        obj = null;
                        break;
                    }
                    Object element$iv$iv3 = it2.next();
                    List dataToSearch$iv2 = dataToSearch$iv;
                    if (element$iv$iv3 instanceof InfiniteTransition) {
                        obj = element$iv$iv3;
                        break;
                    }
                    dataToSearch$iv = dataToSearch$iv2;
                }
                if (!(obj instanceof InfiniteTransition)) {
                    obj = null;
                }
                InfiniteTransition infiniteTransition = (InfiniteTransition) obj;
                Group $this$findData$iv = it;
                Collection<Object> data2 = $this$findData$iv.getData();
                Collection it$iv = $this$findData$iv.getChildren();
                Collection $this$flatMap$iv$iv2 = it$iv;
                Collection destination$iv$iv$iv2 = new ArrayList();
                for (Object element$iv$iv$iv3 : $this$flatMap$iv$iv2) {
                    Group child$iv = (Group) element$iv$iv$iv3;
                    CollectionsKt.addAll(destination$iv$iv$iv2, child$iv.getChildren());
                    $this$mapNotNullTo$iv$iv = $this$mapNotNullTo$iv$iv;
                    $this$findData$iv = $this$findData$iv;
                }
                Iterable $this$mapNotNullTo$iv$iv2 = $this$mapNotNullTo$iv$iv;
                Iterable list$iv$iv$iv = CollectionsKt.plus(it$iv, destination$iv$iv$iv2);
                Collection destination$iv$iv$iv3 = new ArrayList();
                for (Object element$iv$iv$iv4 : list$iv$iv$iv) {
                    Iterable $this$flatMap$iv$iv3 = list$iv$iv$iv;
                    CollectionsKt.addAll(destination$iv$iv$iv3, ((Group) element$iv$iv$iv4).getData());
                    list$iv$iv$iv = $this$flatMap$iv$iv3;
                }
                List dataToSearch$iv3 = CollectionsKt.plus((Collection) data2, destination$iv$iv$iv3);
                List $this$firstOrNull$iv$iv2 = dataToSearch$iv3;
                Iterator it3 = $this$firstOrNull$iv$iv2.iterator();
                while (true) {
                    if (!it3.hasNext()) {
                        obj2 = null;
                        break;
                    }
                    Object element$iv$iv4 = it3.next();
                    List dataToSearch$iv4 = dataToSearch$iv3;
                    if (element$iv$iv4 instanceof MutableState) {
                        obj2 = element$iv$iv4;
                        break;
                    }
                    dataToSearch$iv3 = dataToSearch$iv4;
                }
                if (!(obj2 instanceof MutableState)) {
                    obj2 = null;
                }
                MutableState toolingOverride = (MutableState) obj2;
                if (infiniteTransition != null && toolingOverride != null) {
                    if (toolingOverride.getValue() == null) {
                        toolingOverride.setValue(new ToolingState(0L));
                    }
                    Object value = toolingOverride.getValue();
                    Intrinsics.checkNotNull(value, "null cannot be cast to non-null type androidx.compose.ui.tooling.animation.ToolingState<kotlin.Long>");
                    infiniteTransitionSearchInfo = new InfiniteTransitionSearchInfo(infiniteTransition, (ToolingState) value);
                }
                if (infiniteTransitionSearchInfo != null) {
                    destination$iv$iv3.add(infiniteTransitionSearchInfo);
                }
                it$iv$iv = groups;
                $this$mapNotNull$iv = $this$mapNotNull$iv2;
                $i$f$mapNotNull = $i$f$mapNotNull2;
                $this$mapNotNullTo$iv$iv = $this$mapNotNullTo$iv$iv2;
            }
            return (List) destination$iv$iv3;
        }
    }

    /* compiled from: AnimationSearch.kt */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u0000*\u0004\b\u0000\u0010\u0001*\b\b\u0001\u0010\u0002*\u00020\u00032\u00020\u0004B5\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\b\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\n¢\u0006\u0002\u0010\u000bJ\u0015\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006HÆ\u0003J\u000f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\bHÆ\u0003J\u000f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\nHÆ\u0003JK\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0014\b\u0002\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00062\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\b2\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\nHÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0004HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001R\u001d\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\n¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001d"}, d2 = {"Landroidx/compose/ui/tooling/animation/AnimationSearch$AnimateXAsStateSearchInfo;", "T", "V", "Landroidx/compose/animation/core/AnimationVector;", "", "animatable", "Landroidx/compose/animation/core/Animatable;", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "toolingState", "Landroidx/compose/ui/tooling/animation/ToolingState;", "(Landroidx/compose/animation/core/Animatable;Landroidx/compose/animation/core/AnimationSpec;Landroidx/compose/ui/tooling/animation/ToolingState;)V", "getAnimatable", "()Landroidx/compose/animation/core/Animatable;", "getAnimationSpec", "()Landroidx/compose/animation/core/AnimationSpec;", "getToolingState", "()Landroidx/compose/ui/tooling/animation/ToolingState;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "ui-tooling_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes.dex */
    public static final /* data */ class AnimateXAsStateSearchInfo<T, V extends AnimationVector> {
        public static final int $stable = 8;
        private final Animatable<T, V> animatable;
        private final AnimationSpec<T> animationSpec;
        private final ToolingState<T> toolingState;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ AnimateXAsStateSearchInfo copy$default(AnimateXAsStateSearchInfo animateXAsStateSearchInfo, Animatable animatable, AnimationSpec animationSpec, ToolingState toolingState, int i, Object obj) {
            if ((i & 1) != 0) {
                animatable = animateXAsStateSearchInfo.animatable;
            }
            if ((i & 2) != 0) {
                animationSpec = animateXAsStateSearchInfo.animationSpec;
            }
            if ((i & 4) != 0) {
                toolingState = animateXAsStateSearchInfo.toolingState;
            }
            return animateXAsStateSearchInfo.copy(animatable, animationSpec, toolingState);
        }

        public final Animatable<T, V> component1() {
            return this.animatable;
        }

        public final AnimationSpec<T> component2() {
            return this.animationSpec;
        }

        public final ToolingState<T> component3() {
            return this.toolingState;
        }

        public final AnimateXAsStateSearchInfo<T, V> copy(Animatable<T, V> animatable, AnimationSpec<T> animationSpec, ToolingState<T> toolingState) {
            Intrinsics.checkNotNullParameter(animatable, "animatable");
            Intrinsics.checkNotNullParameter(animationSpec, "animationSpec");
            Intrinsics.checkNotNullParameter(toolingState, "toolingState");
            return new AnimateXAsStateSearchInfo<>(animatable, animationSpec, toolingState);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof AnimateXAsStateSearchInfo)) {
                return false;
            }
            AnimateXAsStateSearchInfo animateXAsStateSearchInfo = (AnimateXAsStateSearchInfo) other;
            return Intrinsics.areEqual(this.animatable, animateXAsStateSearchInfo.animatable) && Intrinsics.areEqual(this.animationSpec, animateXAsStateSearchInfo.animationSpec) && Intrinsics.areEqual(this.toolingState, animateXAsStateSearchInfo.toolingState);
        }

        public int hashCode() {
            return (((this.animatable.hashCode() * 31) + this.animationSpec.hashCode()) * 31) + this.toolingState.hashCode();
        }

        public String toString() {
            return "AnimateXAsStateSearchInfo(animatable=" + this.animatable + ", animationSpec=" + this.animationSpec + ", toolingState=" + this.toolingState + ')';
        }

        public AnimateXAsStateSearchInfo(Animatable<T, V> animatable, AnimationSpec<T> animationSpec, ToolingState<T> toolingState) {
            Intrinsics.checkNotNullParameter(animatable, "animatable");
            Intrinsics.checkNotNullParameter(animationSpec, "animationSpec");
            Intrinsics.checkNotNullParameter(toolingState, "toolingState");
            this.animatable = animatable;
            this.animationSpec = animationSpec;
            this.toolingState = toolingState;
        }

        public final Animatable<T, V> getAnimatable() {
            return this.animatable;
        }

        public final AnimationSpec<T> getAnimationSpec() {
            return this.animationSpec;
        }

        public final ToolingState<T> getToolingState() {
            return this.toolingState;
        }
    }

    /* compiled from: AnimationSearch.kt */
    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\b\u0007\u0018\u00002\u0010\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00020\u0001B!\u0012\u001a\u0010\u0003\u001a\u0016\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0002\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0002\u0010\u0006J\u0016\u0010\u0007\u001a\u00020\u00052\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0016J$\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u0002H\r\u0012\u0004\u0012\u00020\u000e\u0018\u00010\f\"\u0004\b\u0000\u0010\r2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u001e\u0010\u0011\u001a\n\u0012\u0004\u0012\u0002H\r\u0018\u00010\u0012\"\u0004\b\u0000\u0010\r2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J.\u0010\u0013\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\r\u0012\u0004\u0012\u00020\u000e0\u00020\u0014\"\u0004\b\u0000\u0010\r2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0002¨\u0006\u0015"}, d2 = {"Landroidx/compose/ui/tooling/animation/AnimationSearch$AnimateXAsStateSearch;", "Landroidx/compose/ui/tooling/animation/AnimationSearch$Search;", "Landroidx/compose/ui/tooling/animation/AnimationSearch$AnimateXAsStateSearchInfo;", "trackAnimation", "Lkotlin/Function1;", "", "(Lkotlin/jvm/functions/Function1;)V", "addAnimations", "groupsWithLocation", "", "Landroidx/compose/ui/tooling/data/Group;", "findAnimatable", "Landroidx/compose/animation/core/Animatable;", "T", "Landroidx/compose/animation/core/AnimationVector;", "group", "Landroidx/compose/ui/tooling/data/CallGroup;", "findAnimationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "findAnimations", "", "ui-tooling_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes.dex */
    public static final class AnimateXAsStateSearch extends Search<AnimateXAsStateSearchInfo<?, ?>> {
        public static final int $stable = 0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnimateXAsStateSearch(Function1<? super AnimateXAsStateSearchInfo<?, ?>, Unit> trackAnimation) {
            super(trackAnimation);
            Intrinsics.checkNotNullParameter(trackAnimation, "trackAnimation");
        }

        @Override // androidx.compose.ui.tooling.animation.AnimationSearch.Search
        public void addAnimations(Collection<? extends Group> groupsWithLocation) {
            Intrinsics.checkNotNullParameter(groupsWithLocation, "groupsWithLocation");
            getAnimations().addAll(findAnimations(groupsWithLocation));
        }

        private final <T> List<AnimateXAsStateSearchInfo<T, AnimationVector>> findAnimations(Collection<? extends Group> groupsWithLocation) {
            Object obj;
            List rememberCalls$iv;
            Object obj2;
            Iterable $this$mapNotNull$iv;
            Object obj3;
            AnimateXAsStateSearch animateXAsStateSearch = this;
            Collection<? extends Group> $this$filter$iv = groupsWithLocation;
            Collection destination$iv$iv = new ArrayList();
            for (Object element$iv$iv : $this$filter$iv) {
                Group group = (Group) element$iv$iv;
                if (Intrinsics.areEqual(group.getName(), "animateValueAsState")) {
                    destination$iv$iv.add(element$iv$iv);
                }
            }
            Iterable $this$filterIsInstance$iv = (List) destination$iv$iv;
            Collection destination$iv$iv2 = new ArrayList();
            for (T t : $this$filterIsInstance$iv) {
                if (t instanceof CallGroup) {
                    destination$iv$iv2.add(t);
                }
            }
            List groups = (List) destination$iv$iv2;
            List $this$mapNotNull$iv2 = groups;
            int $i$f$mapNotNull = 0;
            Collection destination$iv$iv3 = new ArrayList();
            Iterable $this$mapNotNullTo$iv$iv = $this$mapNotNull$iv2;
            for (Object element$iv$iv$iv : $this$mapNotNullTo$iv$iv) {
                CallGroup it = (CallGroup) element$iv$iv$iv;
                Animatable animatable = animateXAsStateSearch.findAnimatable(it);
                List groups2 = groups;
                AnimationSpec spec = animateXAsStateSearch.findAnimationSpec(it);
                Iterable $this$findRememberedData$iv = it.getChildren();
                Collection destination$iv$iv$iv = new ArrayList();
                Iterator<T> it2 = $this$findRememberedData$iv.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    Object element$iv$iv$iv$iv = it2.next();
                    Group it$iv = (Group) element$iv$iv$iv$iv;
                    Iterable $this$firstOrNull$iv$iv = it$iv.getData();
                    Iterator<T> it3 = $this$firstOrNull$iv$iv.iterator();
                    while (true) {
                        if (!it3.hasNext()) {
                            $this$mapNotNull$iv = $this$mapNotNull$iv2;
                            obj3 = null;
                            break;
                        }
                        Object element$iv$iv2 = it3.next();
                        $this$mapNotNull$iv = $this$mapNotNull$iv2;
                        if (element$iv$iv2 instanceof MutableState) {
                            obj3 = element$iv$iv2;
                            break;
                        }
                        $this$mapNotNull$iv2 = $this$mapNotNull$iv;
                    }
                    int $i$f$mapNotNull2 = $i$f$mapNotNull;
                    MutableState mutableState = (MutableState) (obj3 instanceof MutableState ? obj3 : null);
                    if (mutableState != null) {
                        destination$iv$iv$iv.add(mutableState);
                    }
                    $i$f$mapNotNull = $i$f$mapNotNull2;
                    $this$mapNotNull$iv2 = $this$mapNotNull$iv;
                }
                Iterable $this$mapNotNull$iv3 = $this$mapNotNull$iv2;
                int $i$f$mapNotNull3 = $i$f$mapNotNull;
                List selfData$iv = (List) destination$iv$iv$iv;
                Iterable $this$mapNotNull$iv$iv = $this$findRememberedData$iv;
                Collection destination$iv$iv$iv2 = new ArrayList();
                for (Object element$iv$iv$iv$iv2 : $this$mapNotNull$iv$iv) {
                    Iterable $this$mapNotNull$iv$iv2 = $this$mapNotNull$iv$iv;
                    Group it$iv2 = (Group) element$iv$iv$iv$iv2;
                    Iterable $this$mapNotNullTo$iv$iv2 = $this$mapNotNullTo$iv$iv;
                    Group it$iv3 = PreviewUtilsKt.firstOrNull(it$iv2, AnimationSearchKt$findRememberedData$rememberCalls$1$1.INSTANCE);
                    if (it$iv3 != null) {
                        destination$iv$iv$iv2.add(it$iv3);
                    }
                    $this$mapNotNull$iv$iv = $this$mapNotNull$iv$iv2;
                    $this$mapNotNullTo$iv$iv = $this$mapNotNullTo$iv$iv2;
                }
                Iterable $this$mapNotNullTo$iv$iv3 = $this$mapNotNullTo$iv$iv;
                List rememberCalls$iv2 = (List) destination$iv$iv$iv2;
                List list = selfData$iv;
                List $this$mapNotNull$iv$iv3 = rememberCalls$iv2;
                Collection destination$iv$iv$iv3 = new ArrayList();
                for (Object element$iv$iv$iv$iv3 : $this$mapNotNull$iv$iv3) {
                    Group it$iv4 = (Group) element$iv$iv$iv$iv3;
                    Iterable $this$firstOrNull$iv$iv2 = it$iv4.getData();
                    Iterator<T> it4 = $this$firstOrNull$iv$iv2.iterator();
                    while (true) {
                        if (!it4.hasNext()) {
                            rememberCalls$iv = rememberCalls$iv2;
                            obj2 = null;
                            break;
                        }
                        Object element$iv$iv3 = it4.next();
                        rememberCalls$iv = rememberCalls$iv2;
                        if (element$iv$iv3 instanceof MutableState) {
                            obj2 = element$iv$iv3;
                            break;
                        }
                        rememberCalls$iv2 = rememberCalls$iv;
                    }
                    Iterable $this$firstOrNull$iv$iv3 = $this$mapNotNull$iv$iv3;
                    if (!(obj2 instanceof MutableState)) {
                        obj2 = null;
                    }
                    MutableState mutableState2 = (MutableState) obj2;
                    if (mutableState2 != null) {
                        destination$iv$iv$iv3.add(mutableState2);
                    }
                    $this$mapNotNull$iv$iv3 = $this$firstOrNull$iv$iv3;
                    rememberCalls$iv2 = rememberCalls$iv;
                }
                MutableState toolingOverride = (MutableState) CollectionsKt.firstOrNull(CollectionsKt.plus((Collection) list, destination$iv$iv$iv3));
                if (animatable != null && spec != null && toolingOverride != null) {
                    if (toolingOverride.getValue() == null) {
                        toolingOverride.setValue(new ToolingState(animatable.getValue()));
                    }
                    Object value = toolingOverride.getValue();
                    Intrinsics.checkNotNull(value, "null cannot be cast to non-null type androidx.compose.ui.tooling.animation.ToolingState<T of androidx.compose.ui.tooling.animation.AnimationSearch.AnimateXAsStateSearch.findAnimations$lambda$1>");
                    obj = new AnimateXAsStateSearchInfo(animatable, spec, (ToolingState) value);
                }
                if (obj != null) {
                    Object it$iv$iv = obj;
                    destination$iv$iv3.add(it$iv$iv);
                }
                animateXAsStateSearch = this;
                groups = groups2;
                $i$f$mapNotNull = $i$f$mapNotNull3;
                $this$mapNotNullTo$iv$iv = $this$mapNotNullTo$iv$iv3;
                $this$mapNotNull$iv2 = $this$mapNotNull$iv3;
            }
            return (List) destination$iv$iv3;
        }

        private final <T> AnimationSpec<T> findAnimationSpec(CallGroup group) {
            Iterable $this$filter$iv = group.getChildren();
            Collection destination$iv$iv = new ArrayList();
            for (Object element$iv$iv : $this$filter$iv) {
                Group it = (Group) element$iv$iv;
                if (Intrinsics.areEqual(it.getName(), "rememberUpdatedState")) {
                    destination$iv$iv.add(element$iv$iv);
                }
            }
            Iterable rememberStates = (List) destination$iv$iv;
            ArrayList arrayList = (Collection) rememberStates;
            Iterable $this$flatMap$iv = rememberStates;
            Collection destination$iv$iv2 = new ArrayList();
            for (Object element$iv$iv2 : $this$flatMap$iv) {
                Group it2 = (Group) element$iv$iv2;
                Iterable list$iv$iv = it2.getChildren();
                CollectionsKt.addAll(destination$iv$iv2, list$iv$iv);
            }
            Iterable $this$flatMap$iv2 = CollectionsKt.plus((Collection) arrayList, destination$iv$iv2);
            Collection destination$iv$iv3 = new ArrayList();
            for (Object element$iv$iv3 : $this$flatMap$iv2) {
                Group it3 = (Group) element$iv$iv3;
                Iterable list$iv$iv2 = it3.getData();
                CollectionsKt.addAll(destination$iv$iv3, list$iv$iv2);
            }
            Iterable $this$filterIsInstance$iv = (List) destination$iv$iv3;
            Collection destination$iv$iv4 = new ArrayList();
            for (T t : $this$filterIsInstance$iv) {
                if (t instanceof State) {
                    destination$iv$iv4.add(t);
                }
            }
            Iterable $this$map$iv = (List) destination$iv$iv4;
            Collection destination$iv$iv5 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
            for (Object item$iv$iv : $this$map$iv) {
                State it4 = (State) item$iv$iv;
                destination$iv$iv5.add(it4.getValue());
            }
            Iterable $this$filterIsInstance$iv2 = (List) destination$iv$iv5;
            Collection destination$iv$iv6 = new ArrayList();
            for (T t2 : $this$filterIsInstance$iv2) {
                if (t2 instanceof AnimationSpec) {
                    destination$iv$iv6.add(t2);
                }
            }
            return (AnimationSpec) CollectionsKt.firstOrNull((List) destination$iv$iv6);
        }

        private final <T> Animatable<T, AnimationVector> findAnimatable(CallGroup group) {
            Collection $this$findRememberedData$iv;
            Object obj;
            Object obj2;
            Collection $this$findRememberedData$iv2 = group.getChildren();
            int $i$f$findRememberedData = 0;
            Collection $this$mapNotNull$iv$iv = $this$findRememberedData$iv2;
            Collection destination$iv$iv$iv = new ArrayList();
            for (Object element$iv$iv$iv$iv : $this$mapNotNull$iv$iv) {
                Group it$iv = (Group) element$iv$iv$iv$iv;
                Iterable $this$firstOrNull$iv$iv = it$iv.getData();
                Iterator<T> it = $this$firstOrNull$iv$iv.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        obj2 = null;
                        break;
                    }
                    Object element$iv$iv = it.next();
                    if (element$iv$iv instanceof Animatable) {
                        obj2 = element$iv$iv;
                        break;
                    }
                }
                int $i$f$findRememberedData2 = $i$f$findRememberedData;
                if (!(obj2 instanceof Animatable)) {
                    obj2 = null;
                }
                Animatable animatable = (Animatable) obj2;
                if (animatable != null) {
                    destination$iv$iv$iv.add(animatable);
                }
                $i$f$findRememberedData = $i$f$findRememberedData2;
            }
            List selfData$iv = (List) destination$iv$iv$iv;
            Collection $this$mapNotNull$iv$iv2 = $this$findRememberedData$iv2;
            Collection destination$iv$iv$iv2 = new ArrayList();
            for (Object element$iv$iv$iv$iv2 : $this$mapNotNull$iv$iv2) {
                Group it$iv2 = (Group) element$iv$iv$iv$iv2;
                Group it$iv3 = PreviewUtilsKt.firstOrNull(it$iv2, AnimationSearchKt$findRememberedData$rememberCalls$1$1.INSTANCE);
                if (it$iv3 != null) {
                    destination$iv$iv$iv2.add(it$iv3);
                }
            }
            Iterable rememberCalls$iv = (List) destination$iv$iv$iv2;
            List list = selfData$iv;
            Iterable $this$mapNotNull$iv$iv3 = rememberCalls$iv;
            Collection destination$iv$iv$iv3 = new ArrayList();
            for (Object element$iv$iv$iv$iv3 : $this$mapNotNull$iv$iv3) {
                Group it$iv4 = (Group) element$iv$iv$iv$iv3;
                Iterable $this$firstOrNull$iv$iv2 = it$iv4.getData();
                Iterator<T> it2 = $this$firstOrNull$iv$iv2.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        $this$findRememberedData$iv = $this$findRememberedData$iv2;
                        obj = null;
                        break;
                    }
                    Object element$iv$iv2 = it2.next();
                    $this$findRememberedData$iv = $this$findRememberedData$iv2;
                    if (element$iv$iv2 instanceof Animatable) {
                        obj = element$iv$iv2;
                        break;
                    }
                    $this$findRememberedData$iv2 = $this$findRememberedData$iv;
                }
                List $this$firstOrNull$iv$iv3 = selfData$iv;
                if (!(obj instanceof Animatable)) {
                    obj = null;
                }
                Animatable animatable2 = (Animatable) obj;
                if (animatable2 != null) {
                    destination$iv$iv$iv3.add(animatable2);
                }
                selfData$iv = $this$firstOrNull$iv$iv3;
                $this$findRememberedData$iv2 = $this$findRememberedData$iv;
            }
            return (Animatable) CollectionsKt.firstOrNull(CollectionsKt.plus((Collection) list, destination$iv$iv$iv3));
        }
    }

    /* compiled from: AnimationSearch.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0019\u0012\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0002\u0010\u0006J\u0016\u0010\u0007\u001a\u00020\u00052\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0016¨\u0006\u000b"}, d2 = {"Landroidx/compose/ui/tooling/animation/AnimationSearch$AnimateContentSizeSearch;", "Landroidx/compose/ui/tooling/animation/AnimationSearch$Search;", "", "trackAnimation", "Lkotlin/Function1;", "", "(Lkotlin/jvm/functions/Function1;)V", "addAnimations", "groupsWithLocation", "", "Landroidx/compose/ui/tooling/data/Group;", "ui-tooling_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes.dex */
    public static final class AnimateContentSizeSearch extends Search<Object> {
        public static final int $stable = 0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnimateContentSizeSearch(Function1<Object, Unit> trackAnimation) {
            super(trackAnimation);
            Intrinsics.checkNotNullParameter(trackAnimation, "trackAnimation");
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.compose.ui.tooling.animation.AnimationSearch.Search
        public void addAnimations(Collection<? extends Group> groupsWithLocation) {
            String str;
            Iterable $this$mapNotNull$iv;
            Class<?> cls;
            Intrinsics.checkNotNullParameter(groupsWithLocation, "groupsWithLocation");
            Set<Object> animations = getAnimations();
            Collection<? extends Group> $this$filter$iv = groupsWithLocation;
            Collection destination$iv$iv = new ArrayList();
            for (Object element$iv$iv : $this$filter$iv) {
                Group call = (Group) element$iv$iv;
                if (Intrinsics.areEqual(call.getName(), "remember")) {
                    destination$iv$iv.add(element$iv$iv);
                }
            }
            Iterable $this$mapNotNull$iv2 = (List) destination$iv$iv;
            Collection destination$iv$iv2 = new ArrayList();
            for (Object element$iv$iv$iv : $this$mapNotNull$iv2) {
                Group it = (Group) element$iv$iv$iv;
                Iterable $this$firstOrNull$iv = it.getData();
                Iterator it2 = $this$firstOrNull$iv.iterator();
                while (true) {
                    str = null;
                    if (!it2.hasNext()) {
                        $this$mapNotNull$iv = $this$mapNotNull$iv2;
                        break;
                    }
                    Object next = it2.next();
                    if (next != 0 && (cls = next.getClass()) != null) {
                        str = cls.getName();
                    }
                    $this$mapNotNull$iv = $this$mapNotNull$iv2;
                    if (Intrinsics.areEqual(str, "androidx.compose.animation.SizeAnimationModifier")) {
                        str = next;
                        break;
                    }
                    $this$mapNotNull$iv2 = $this$mapNotNull$iv;
                }
                if (str != null) {
                    destination$iv$iv2.add(str);
                }
                $this$mapNotNull$iv2 = $this$mapNotNull$iv;
            }
            animations.addAll(CollectionsKt.toSet((List) destination$iv$iv2));
        }
    }

    /* compiled from: AnimationSearch.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u0001B\u001d\u0012\u0016\u0010\u0003\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0002\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0002\u0010\u0006J\u0016\u0010\u0007\u001a\u00020\u00052\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0016¨\u0006\u000b"}, d2 = {"Landroidx/compose/ui/tooling/animation/AnimationSearch$TransitionSearch;", "Landroidx/compose/ui/tooling/animation/AnimationSearch$Search;", "Landroidx/compose/animation/core/Transition;", "trackAnimation", "Lkotlin/Function1;", "", "(Lkotlin/jvm/functions/Function1;)V", "addAnimations", "groupsWithLocation", "", "Landroidx/compose/ui/tooling/data/Group;", "ui-tooling_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes.dex */
    public static final class TransitionSearch extends Search<Transition<?>> {
        public static final int $stable = 0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public TransitionSearch(Function1<? super Transition<?>, Unit> trackAnimation) {
            super(trackAnimation);
            Intrinsics.checkNotNullParameter(trackAnimation, "trackAnimation");
        }

        @Override // androidx.compose.ui.tooling.animation.AnimationSearch.Search
        public void addAnimations(Collection<? extends Group> groupsWithLocation) {
            List selfData$iv;
            Object obj;
            Object obj2;
            Intrinsics.checkNotNullParameter(groupsWithLocation, "groupsWithLocation");
            Set<Transition<?>> animations = getAnimations();
            Collection<? extends Group> $this$filter$iv = groupsWithLocation;
            Collection destination$iv$iv = new ArrayList();
            for (Object element$iv$iv : $this$filter$iv) {
                Group it = (Group) element$iv$iv;
                if (Intrinsics.areEqual(it.getName(), "updateTransition")) {
                    destination$iv$iv.add(element$iv$iv);
                }
            }
            Object it$iv$iv$iv = (Collection) ((List) destination$iv$iv);
            Iterable $this$mapNotNull$iv$iv = (Iterable) it$iv$iv$iv;
            Collection destination$iv$iv$iv = new ArrayList();
            for (Object element$iv$iv$iv$iv : $this$mapNotNull$iv$iv) {
                Group it$iv = (Group) element$iv$iv$iv$iv;
                Iterable $this$firstOrNull$iv$iv = it$iv.getData();
                Iterator it2 = $this$firstOrNull$iv$iv.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        obj2 = null;
                        break;
                    }
                    Object element$iv$iv2 = it2.next();
                    if (element$iv$iv2 instanceof Transition) {
                        obj2 = element$iv$iv2;
                        break;
                    }
                }
                if (!(obj2 instanceof Transition)) {
                    obj2 = null;
                }
                Transition transition = (Transition) obj2;
                if (transition != null) {
                    destination$iv$iv$iv.add(transition);
                }
            }
            List selfData$iv2 = (List) destination$iv$iv$iv;
            Iterable $this$mapNotNull$iv$iv2 = (Iterable) it$iv$iv$iv;
            Collection destination$iv$iv$iv2 = new ArrayList();
            for (Object element$iv$iv$iv$iv2 : $this$mapNotNull$iv$iv2) {
                Group it$iv2 = (Group) element$iv$iv$iv$iv2;
                Object $this$findRememberedData$iv = it$iv$iv$iv;
                Group firstOrNull = PreviewUtilsKt.firstOrNull(it$iv2, AnimationSearchKt$findRememberedData$rememberCalls$1$1.INSTANCE);
                if (firstOrNull != null) {
                    destination$iv$iv$iv2.add(firstOrNull);
                }
                it$iv$iv$iv = $this$findRememberedData$iv;
            }
            List rememberCalls$iv = (List) destination$iv$iv$iv2;
            List list = selfData$iv2;
            List $this$mapNotNull$iv$iv3 = rememberCalls$iv;
            Collection destination$iv$iv$iv3 = new ArrayList();
            for (Object element$iv$iv$iv$iv3 : $this$mapNotNull$iv$iv3) {
                Group it$iv3 = (Group) element$iv$iv$iv$iv3;
                Iterable $this$firstOrNull$iv$iv2 = it$iv3.getData();
                Iterator it3 = $this$firstOrNull$iv$iv2.iterator();
                while (true) {
                    if (!it3.hasNext()) {
                        selfData$iv = selfData$iv2;
                        obj = null;
                        break;
                    }
                    Object element$iv$iv3 = it3.next();
                    selfData$iv = selfData$iv2;
                    if (element$iv$iv3 instanceof Transition) {
                        obj = element$iv$iv3;
                        break;
                    }
                    selfData$iv2 = selfData$iv;
                }
                List $this$firstOrNull$iv$iv3 = rememberCalls$iv;
                if (!(obj instanceof Transition)) {
                    obj = null;
                }
                Transition transition2 = (Transition) obj;
                if (transition2 != null) {
                    destination$iv$iv$iv3.add(transition2);
                }
                rememberCalls$iv = $this$firstOrNull$iv$iv3;
                selfData$iv2 = selfData$iv;
            }
            animations.addAll(CollectionsKt.plus((Collection) list, destination$iv$iv$iv3));
        }
    }

    /* compiled from: AnimationSearch.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u0001B\u001d\u0012\u0016\u0010\u0003\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0002\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0002\u0010\u0006J\u0016\u0010\u0007\u001a\u00020\u00052\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0016¨\u0006\u000b"}, d2 = {"Landroidx/compose/ui/tooling/animation/AnimationSearch$AnimatedVisibilitySearch;", "Landroidx/compose/ui/tooling/animation/AnimationSearch$Search;", "Landroidx/compose/animation/core/Transition;", "trackAnimation", "Lkotlin/Function1;", "", "(Lkotlin/jvm/functions/Function1;)V", "addAnimations", "groupsWithLocation", "", "Landroidx/compose/ui/tooling/data/Group;", "ui-tooling_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes.dex */
    public static final class AnimatedVisibilitySearch extends Search<Transition<?>> {
        public static final int $stable = 0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnimatedVisibilitySearch(Function1<? super Transition<?>, Unit> trackAnimation) {
            super(trackAnimation);
            Intrinsics.checkNotNullParameter(trackAnimation, "trackAnimation");
        }

        @Override // androidx.compose.ui.tooling.animation.AnimationSearch.Search
        public void addAnimations(Collection<? extends Group> groupsWithLocation) {
            List rememberCalls$iv;
            Object obj;
            int $i$f$findRememberedData;
            Object obj2;
            Object obj3;
            Intrinsics.checkNotNullParameter(groupsWithLocation, "groupsWithLocation");
            Set<Transition<?>> animations = getAnimations();
            Collection<? extends Group> $this$filter$iv = groupsWithLocation;
            Collection destination$iv$iv = new ArrayList();
            for (Object element$iv$iv : $this$filter$iv) {
                Group it = (Group) element$iv$iv;
                if (Intrinsics.areEqual(it.getName(), "AnimatedVisibility")) {
                    destination$iv$iv.add(element$iv$iv);
                }
            }
            Iterable $this$mapNotNull$iv = (List) destination$iv$iv;
            Collection destination$iv$iv2 = new ArrayList();
            for (Object element$iv$iv$iv : $this$mapNotNull$iv) {
                Group it2 = (Group) element$iv$iv$iv;
                Iterable $this$firstOrNull$iv = it2.getChildren();
                Iterator it3 = $this$firstOrNull$iv.iterator();
                while (true) {
                    if (!it3.hasNext()) {
                        obj3 = null;
                        break;
                    }
                    Object element$iv = it3.next();
                    Group updateTransitionCall = (Group) element$iv;
                    if (Intrinsics.areEqual(updateTransitionCall.getName(), "updateTransition")) {
                        obj3 = element$iv;
                        break;
                    }
                }
                Group group = (Group) obj3;
                if (group != null) {
                    destination$iv$iv2.add(group);
                }
            }
            Object it$iv$iv$iv = (Collection) ((List) destination$iv$iv2);
            int $i$f$findRememberedData2 = 0;
            Iterable $this$mapNotNull$iv$iv = (Iterable) it$iv$iv$iv;
            Collection destination$iv$iv$iv = new ArrayList();
            for (Object element$iv$iv$iv$iv : $this$mapNotNull$iv$iv) {
                Group it$iv = (Group) element$iv$iv$iv$iv;
                Iterable $this$firstOrNull$iv$iv = it$iv.getData();
                Iterator it4 = $this$firstOrNull$iv$iv.iterator();
                while (true) {
                    if (!it4.hasNext()) {
                        $i$f$findRememberedData = $i$f$findRememberedData2;
                        obj2 = null;
                        break;
                    }
                    Object element$iv$iv2 = it4.next();
                    $i$f$findRememberedData = $i$f$findRememberedData2;
                    if (element$iv$iv2 instanceof Transition) {
                        obj2 = element$iv$iv2;
                        break;
                    }
                    $i$f$findRememberedData2 = $i$f$findRememberedData;
                }
                Iterable $this$firstOrNull$iv$iv2 = $this$mapNotNull$iv$iv;
                if (!(obj2 instanceof Transition)) {
                    obj2 = null;
                }
                Transition transition = (Transition) obj2;
                if (transition != null) {
                    destination$iv$iv$iv.add(transition);
                }
                $this$mapNotNull$iv$iv = $this$firstOrNull$iv$iv2;
                $i$f$findRememberedData2 = $i$f$findRememberedData;
            }
            List selfData$iv = (List) destination$iv$iv$iv;
            Collection destination$iv$iv$iv2 = new ArrayList();
            for (Object element$iv$iv$iv$iv2 : (Iterable) it$iv$iv$iv) {
                Group it$iv2 = (Group) element$iv$iv$iv$iv2;
                Object $this$findRememberedData$iv = it$iv$iv$iv;
                Group firstOrNull = PreviewUtilsKt.firstOrNull(it$iv2, AnimationSearchKt$findRememberedData$rememberCalls$1$1.INSTANCE);
                if (firstOrNull != null) {
                    destination$iv$iv$iv2.add(firstOrNull);
                }
                it$iv$iv$iv = $this$findRememberedData$iv;
            }
            List rememberCalls$iv2 = (List) destination$iv$iv$iv2;
            List list = selfData$iv;
            Collection destination$iv$iv$iv3 = new ArrayList();
            for (Object element$iv$iv$iv$iv3 : rememberCalls$iv2) {
                Group it$iv3 = (Group) element$iv$iv$iv$iv3;
                Iterable $this$firstOrNull$iv$iv3 = it$iv3.getData();
                Iterator it5 = $this$firstOrNull$iv$iv3.iterator();
                while (true) {
                    if (!it5.hasNext()) {
                        rememberCalls$iv = rememberCalls$iv2;
                        obj = null;
                        break;
                    }
                    Object element$iv$iv3 = it5.next();
                    rememberCalls$iv = rememberCalls$iv2;
                    if (element$iv$iv3 instanceof Transition) {
                        obj = element$iv$iv3;
                        break;
                    }
                    rememberCalls$iv2 = rememberCalls$iv;
                }
                List $this$firstOrNull$iv$iv4 = selfData$iv;
                if (!(obj instanceof Transition)) {
                    obj = null;
                }
                Transition transition2 = (Transition) obj;
                if (transition2 != null) {
                    destination$iv$iv$iv3.add(transition2);
                }
                selfData$iv = $this$firstOrNull$iv$iv4;
                rememberCalls$iv2 = rememberCalls$iv;
            }
            animations.addAll(CollectionsKt.plus((Collection) list, destination$iv$iv$iv3));
        }
    }

    /* compiled from: AnimationSearch.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u0001B\u001d\u0012\u0016\u0010\u0003\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0002\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0002\u0010\u0006J\u0016\u0010\u0007\u001a\u00020\u00052\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0016¨\u0006\u000b"}, d2 = {"Landroidx/compose/ui/tooling/animation/AnimationSearch$AnimatedContentSearch;", "Landroidx/compose/ui/tooling/animation/AnimationSearch$Search;", "Landroidx/compose/animation/core/Transition;", "trackAnimation", "Lkotlin/Function1;", "", "(Lkotlin/jvm/functions/Function1;)V", "addAnimations", "groupsWithLocation", "", "Landroidx/compose/ui/tooling/data/Group;", "ui-tooling_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes.dex */
    public static final class AnimatedContentSearch extends Search<Transition<?>> {
        public static final int $stable = 0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnimatedContentSearch(Function1<? super Transition<?>, Unit> trackAnimation) {
            super(trackAnimation);
            Intrinsics.checkNotNullParameter(trackAnimation, "trackAnimation");
        }

        @Override // androidx.compose.ui.tooling.animation.AnimationSearch.Search
        public void addAnimations(Collection<? extends Group> groupsWithLocation) {
            List rememberCalls$iv;
            Object obj;
            int $i$f$findRememberedData;
            Object obj2;
            Object obj3;
            Intrinsics.checkNotNullParameter(groupsWithLocation, "groupsWithLocation");
            Set<Transition<?>> animations = getAnimations();
            Collection<? extends Group> $this$filter$iv = groupsWithLocation;
            Collection destination$iv$iv = new ArrayList();
            for (Object element$iv$iv : $this$filter$iv) {
                Group it = (Group) element$iv$iv;
                if (Intrinsics.areEqual(it.getName(), "AnimatedContent")) {
                    destination$iv$iv.add(element$iv$iv);
                }
            }
            Iterable $this$mapNotNull$iv = (List) destination$iv$iv;
            Collection destination$iv$iv2 = new ArrayList();
            for (Object element$iv$iv$iv : $this$mapNotNull$iv) {
                Group it2 = (Group) element$iv$iv$iv;
                Iterable $this$firstOrNull$iv = it2.getChildren();
                Iterator it3 = $this$firstOrNull$iv.iterator();
                while (true) {
                    if (!it3.hasNext()) {
                        obj3 = null;
                        break;
                    }
                    Object element$iv = it3.next();
                    Group updateTransitionCall = (Group) element$iv;
                    if (Intrinsics.areEqual(updateTransitionCall.getName(), "updateTransition")) {
                        obj3 = element$iv;
                        break;
                    }
                }
                Group group = (Group) obj3;
                if (group != null) {
                    destination$iv$iv2.add(group);
                }
            }
            Object it$iv$iv$iv = (Collection) ((List) destination$iv$iv2);
            int $i$f$findRememberedData2 = 0;
            Iterable $this$mapNotNull$iv$iv = (Iterable) it$iv$iv$iv;
            Collection destination$iv$iv$iv = new ArrayList();
            for (Object element$iv$iv$iv$iv : $this$mapNotNull$iv$iv) {
                Group it$iv = (Group) element$iv$iv$iv$iv;
                Iterable $this$firstOrNull$iv$iv = it$iv.getData();
                Iterator it4 = $this$firstOrNull$iv$iv.iterator();
                while (true) {
                    if (!it4.hasNext()) {
                        $i$f$findRememberedData = $i$f$findRememberedData2;
                        obj2 = null;
                        break;
                    }
                    Object element$iv$iv2 = it4.next();
                    $i$f$findRememberedData = $i$f$findRememberedData2;
                    if (element$iv$iv2 instanceof Transition) {
                        obj2 = element$iv$iv2;
                        break;
                    }
                    $i$f$findRememberedData2 = $i$f$findRememberedData;
                }
                Iterable $this$firstOrNull$iv$iv2 = $this$mapNotNull$iv$iv;
                if (!(obj2 instanceof Transition)) {
                    obj2 = null;
                }
                Transition transition = (Transition) obj2;
                if (transition != null) {
                    destination$iv$iv$iv.add(transition);
                }
                $this$mapNotNull$iv$iv = $this$firstOrNull$iv$iv2;
                $i$f$findRememberedData2 = $i$f$findRememberedData;
            }
            List selfData$iv = (List) destination$iv$iv$iv;
            Collection destination$iv$iv$iv2 = new ArrayList();
            for (Object element$iv$iv$iv$iv2 : (Iterable) it$iv$iv$iv) {
                Group it$iv2 = (Group) element$iv$iv$iv$iv2;
                Object $this$findRememberedData$iv = it$iv$iv$iv;
                Group firstOrNull = PreviewUtilsKt.firstOrNull(it$iv2, AnimationSearchKt$findRememberedData$rememberCalls$1$1.INSTANCE);
                if (firstOrNull != null) {
                    destination$iv$iv$iv2.add(firstOrNull);
                }
                it$iv$iv$iv = $this$findRememberedData$iv;
            }
            List rememberCalls$iv2 = (List) destination$iv$iv$iv2;
            List list = selfData$iv;
            Collection destination$iv$iv$iv3 = new ArrayList();
            for (Object element$iv$iv$iv$iv3 : rememberCalls$iv2) {
                Group it$iv3 = (Group) element$iv$iv$iv$iv3;
                Iterable $this$firstOrNull$iv$iv3 = it$iv3.getData();
                Iterator it5 = $this$firstOrNull$iv$iv3.iterator();
                while (true) {
                    if (!it5.hasNext()) {
                        rememberCalls$iv = rememberCalls$iv2;
                        obj = null;
                        break;
                    }
                    Object element$iv$iv3 = it5.next();
                    rememberCalls$iv = rememberCalls$iv2;
                    if (element$iv$iv3 instanceof Transition) {
                        obj = element$iv$iv3;
                        break;
                    }
                    rememberCalls$iv2 = rememberCalls$iv;
                }
                List $this$firstOrNull$iv$iv4 = selfData$iv;
                if (!(obj instanceof Transition)) {
                    obj = null;
                }
                Transition transition2 = (Transition) obj;
                if (transition2 != null) {
                    destination$iv$iv$iv3.add(transition2);
                }
                selfData$iv = $this$firstOrNull$iv$iv4;
                rememberCalls$iv2 = rememberCalls$iv;
            }
            animations.addAll(CollectionsKt.plus((Collection) list, destination$iv$iv$iv3));
        }
    }
}
