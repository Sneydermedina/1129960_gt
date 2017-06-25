(function () {
    var docElem = window.document.documentElement, didScroll, scrollPosition;
    function noScrollFn() {
        window.scrollTo(scrollPosition ? scrollPosition.x : 0, scrollPosition ? scrollPosition.y : 0);
    }

    function noScroll() {
        window.removeEventListener('scroll', scrollHandler);
        window.addEventListener('scroll', noScrollFn);
    }

    function scrollFn() {
        window.addEventListener('scroll', scrollHandler);
    }

    function canScroll() {
        window.removeEventListener('scroll', noScrollFn);
        scrollFn();
    }

    function scrollHandler() {
        if (!didScroll) {
            didScroll = true;
            setTimeout(function () {
                scrollPage();
            }, 60);
        }
    }
    ;

    function scrollPage() {
        scrollPosition = {x: window.pageXOffset || docElem.scrollLeft, y: window.pageYOffset || docElem.scrollTop};
        didScroll = false;
    }
    ;

    scrollFn();

    var el = document.querySelector('.morph-button2');

    new UIMorphingButton(el, {
        closeEl: '.icon-close2',
        onBeforeOpen: function () {
            noScroll();
        },
        onAfterOpen: function () {
            canScroll();
            classie.addClass(document.body, 'noscroll');
            classie.addClass(el, 'scroll');
        },
        onBeforeClose: function () {
            classie.removeClass(document.body, 'noscroll');
            classie.removeClass(el, 'scroll');
            noScroll();
        },
        onAfterClose: function () {
            canScroll();
        }
    });
})();