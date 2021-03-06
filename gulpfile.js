var gulp = require('gulp'),
    gutil = require('gulp-util'),
    webserver = require('gulp-webserver');

gulp.task('js', function() {
    gulp.src('builds/dmv_js/**/*');
});

gulp.task('html', function() {
    gulp.src('builds/*.html');
});

gulp.task('json', function() {
    gulp.src('builds/json/*.json');
});

gulp.task('css', function() {
    gulp.src('builds/dmv_css/*.css');
});

gulp.task('watch', function() {
    gulp.watch('builds/dmv_js/**/*', ['js']);
    gulp.watch('builds/dmv_css/*.css', ['css']);
    gulp.watch(['builds/json/*.json'], ['json']);
    gulp.watch(['builds/*.html',
        'builds/views/*.html'], ['html']);
});

gulp.task('webserver', function() {
    gulp.src('builds/')
        .pipe(webserver({
            livereload: true,
            open: true
        }));
});

gulp.task('default', ['watch', 'html', 'js', 'css','json', 'webserver']);
