if [ "$TRAVIS_PULL_REQUEST" = false ]; then
  cd $TRAVIS_BUILD_DIR/app/build/outputs/apk/release/

  for apk in $(find *.apk -type f); do
    apkName="${apk::4}"
    echo $apkName

  done
fi
