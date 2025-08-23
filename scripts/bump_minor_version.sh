#!/bin/bash
set -e

# Fetch all tags
echo "Fetch tags"
git fetch --tags --force

# Now list tags
echo "List tags"
git tag

LATEST_TAG=$(git tag --sort=-creatordate | head -n1 || echo "v0.0.0")
echo "Current latest tag: $LATEST_TAG"

# Parse major, minor, patch
IFS='.' read -r major minor patch <<< "${LATEST_TAG#v}"

# Bump minor version
minor=$((minor + 1))
NEW_TAG="v$major.$minor.0"
echo "Bumping to new tag: $NEW_TAG"

# Create and push the new tag
git tag $NEW_TAG
git push https://x-access-token:${GITHUB_TOKEN}@github.com/${GITHUB_REPOSITORY}.git $NEW_TAG

# Export new tag for GitHub Actions
echo "NEW_TAG=$NEW_TAG" >> $GITHUB_ENV
