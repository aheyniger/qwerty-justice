$(document).ready(function () {
    // Initialize Owl Carousel with more features
    $(".custom-carousel").owlCarousel({
      autoWidth: true,      // Items adjust their width based on content
      loop: true,           // Enable looping of the carousel
      margin: 10,           // Add margin between items
      nav: false,            // Enable navigation arrows (next/prev)
      dots: true,           // Enable dots navigation
      autoplay: false,       // Enable autoplay
      autoplayTimeout: 3000, // Autoplay timeout (3 seconds)
      responsive: {
        0: {
          items: 1          // Show 1 item for smaller screens
        },
        600: {
          items: 2          // Show 2 items for medium screens
        },
        1000: {
          items: 3          // Show 3 items for larger screens
        }
      }
    });
  
    // Handle item click interaction
    $(".custom-carousel .item").click(function () {
      $(".custom-carousel .item").not($(this)).removeClass("active");
      $(this).toggleClass("active");
    });
  });
  